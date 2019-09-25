package cn.hug.boot.app.aspect;

import cn.hug.boot.api.exception.BusinessException;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 日志拦截器
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-25 16:01
 */
@Slf4j
@Aspect
@Component
public class ControllerAspect {
    /**
     * Controller aspect.
     */
    @Pointcut("execution(* cn.hug.boot.app.controller.*.*(..))")
        public void controllerAspect() {
    }

    /**
     * Around 手动控制调用核心业务逻辑，以及调用前和调用后的处理,
     * <p>
     * 注意：当核心业务抛异常后，立即退出，转向AfterAdvice 执行完AfterAdvice，再转到ThrowingAdvice
     *
     * @param pjp the pjp
     * @return object
     * @throws Throwable the throwable
     */
    @Around(value = "controllerAspect()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        //防止不是http请求的方法，例如：scheduled
        if (ra == null || sra == null) {
            return pjp.proceed();
        }
        HttpServletRequest request = sra.getRequest();

        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
        log.info("REQUEST_ARGS : " + JSON.toJSONString(pjp.getArgs()));

        long startTime = System.currentTimeMillis();
        try {
            Object response = pjp.proceed();
            // 3.出参打印
            log.info("RESPONSE:{}", response != null ? JSON.toJSONString(response) : "");
            return response;
        } catch (Throwable e) {
            if (e instanceof BusinessException) {
                log.info("RESPONSE_ERROR:{}", e.getMessage());
            } else if (e instanceof MethodArgumentNotValidException) {
                log.info("RESPONSE_ERROR:{}", e.getMessage());
            } else {
                log.error("RESPONSE_ERROR:{}", Arrays.toString(e.getStackTrace()));
            }
            throw e;
        } finally {
            long endTime = System.currentTimeMillis();
            log.info("SPEND TIME : {}ms", (endTime - startTime));
        }
    }
}
