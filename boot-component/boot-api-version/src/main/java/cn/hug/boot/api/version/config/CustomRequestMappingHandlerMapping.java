package cn.hug.boot.api.version.config;

import cn.hug.boot.api.version.annotation.ApiVersion;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * 重写RequestMappingHandlerMapping
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-07-26 15:29
 */
public class CustomRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestCondition<ApiRequestCondition> getCustomTypeCondition(Class<?> handlerType) {
        ApiVersion apiVersion = AnnotationUtils.findAnnotation(handlerType, ApiVersion.class);
        return createCondition(apiVersion);
    }

    @Override
    protected RequestCondition<ApiRequestCondition> getCustomMethodCondition(Method method) {
        ApiVersion apiVersion = AnnotationUtils.findAnnotation(method, ApiVersion.class);
        return createCondition(apiVersion);
    }

    private RequestCondition<ApiRequestCondition> createCondition(ApiVersion apiVersion) {
        return apiVersion == null ? null : new ApiRequestCondition(apiVersion.value());
    }
}
