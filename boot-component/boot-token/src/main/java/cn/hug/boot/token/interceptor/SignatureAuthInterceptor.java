package cn.hug.boot.token.interceptor;

import cn.hug.boot.api.util.JsonUtils;
import cn.hug.boot.token.service.ISignatureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 签名验证拦截器
 * @author: huangwh
 * @date: 2019/11/3 0:18
 */
@Slf4j
@Component
public class SignatureAuthInterceptor implements HandlerInterceptor {
    @Autowired
    private ISignatureService signatureService;

    /**
     * 预处理回调方法，实现处理器的预处理
     * 返回值：true表示继续流程；false表示流程中断，不会继续调用其他的拦截器或处理器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("验证签名.........");

        boolean auth = true;
        String method = request.getMethod();
        log.info("method:{}", method);

        String token = request.getHeader("token");
        String timestamp = request.getHeader("timestamp");
        String signature = request.getHeader("signature");

        switch (method) {
            case "GET": this.authUrlParam(request, token, timestamp, signature); break;
            case "POST": this.authBodyParam(request, token, timestamp, signature); break;
            default: auth = false;
        }

        return auth;
    }

    /**
     * 后处理回调方法，实现处理器（controller）的后处理，但在渲染视图之前
     * 此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }
    /**
     * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，
     * 如性能监控中我们可以在此记录结束时间并输出消耗时间，
     * 还可以进行一些资源清理，类似于try-catch-finally中的finally，
     * 但仅调用处理器执行链中
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

    /**
     * 验证body参数
     * @param request
     * @return
     */
    private void authBodyParam(HttpServletRequest request, String token, String timestamp, String signature) {
        RequestWrapper requestWrapper = new RequestWrapper(request);
        // 获取@RequestBody注解参数和post请求参数
        String body = requestWrapper.getBody();
        log.info("拦截器输出body：" + body);

        Map<String, Object> paramBody = JsonUtils.jsonStringToMap(body);
        signatureService.authSignature(paramBody,token, timestamp, signature);
    }

    /**
     * 验证url参数
     * @param request
     * @return
     */
    private void authUrlParam(HttpServletRequest request, String token, String timestamp, String signature) {
        Map<String, String[]> ParameterMap = request.getParameterMap();
        log.info("参数个数：" + ParameterMap.size());
        Map<String, Object> paramBody = new HashMap();
        Set<Map.Entry<String, String[]>> entry = ParameterMap.entrySet();
        Iterator<Map.Entry<String, String[]>> it = entry.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String[]> me = it.next();
            String key = me.getKey();
            String value = me.getValue()[0];
            paramBody.put(key, value);
        }

        signatureService.authSignature(paramBody, token, timestamp, signature);
    }
}
