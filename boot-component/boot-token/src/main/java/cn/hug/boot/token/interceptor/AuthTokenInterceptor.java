package cn.hug.boot.token.interceptor;

import cn.hug.boot.token.annotation.AuthToken;
import cn.hug.boot.token.service.ITokenService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * token认证
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-25 14:38
 */
@Slf4j
@Component
@Order(-99)
@Aspect
public class AuthTokenInterceptor {
    @Autowired
    private ITokenService tokenService;

    @Pointcut("@annotation(cn.hug.boot.token.annotation.AuthToken)")
    public void exPointCut() {
    }

    @Before("exPointCut() && @annotation(authToken)")
    public void before(JoinPoint joinPoint, AuthToken authToken) {
        // 接收到请求，获取uri
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String token = request.getHeader("token");
        log.info("token:{}", token);

        tokenService.authentication(token);
    }
}
