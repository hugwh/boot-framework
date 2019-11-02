package cn.hug.boot.app.config;

import cn.hug.boot.token.interceptor.SignatureAuthInterceptor;
import cn.hug.boot.token.interceptor.TokenAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author: huangwh
 * @date: 2019/11/3 0:22
 */
@Configuration
public class MvcInterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private TokenAuthInterceptor tokenAuthInterceptor;
    @Autowired
    private SignatureAuthInterceptor signatureAuthInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则，/**表示拦截所有请求
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(tokenAuthInterceptor).addPathPatterns("/**").order(-999);

        registry.addInterceptor(signatureAuthInterceptor).addPathPatterns("/**").order(-998);
        super.addInterceptors(registry);
    }
}
