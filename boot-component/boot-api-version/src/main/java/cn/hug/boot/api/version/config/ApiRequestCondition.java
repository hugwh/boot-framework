package cn.hug.boot.api.version.config;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

/**
 * api version 条件过滤
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-07-26 15:23
 */
@Slf4j
@Order(99)
public class ApiRequestCondition implements RequestCondition<ApiRequestCondition> {
    private int apiVersion;

    public ApiRequestCondition(int apiVersion) {
        this.apiVersion = apiVersion;
    }

    public int getApiVersion() {
        return apiVersion;
    }

    @Override
    public ApiRequestCondition combine(ApiRequestCondition other) {
        // 采用最后定义优先原则，则方法上的定义覆盖类上面的定义
        return new ApiRequestCondition(other.getApiVersion());
    }

    @Override
    public int compareTo(ApiRequestCondition other, HttpServletRequest request) {
        //对符合请求版本的版本号进行排序
        return other.getApiVersion() - this.apiVersion;
    }

    @Override
    public ApiRequestCondition getMatchingCondition(HttpServletRequest request) {
        //设置默认版本号，请求版本号错误时使用最新版本号的接口
        Integer version = 10000;

        String apiversion = request.getHeader("version");
        if (StrUtil.isNotEmpty(apiversion)) {
            version = Integer.valueOf(apiversion.replace(".", ""));
        }
        // 返回小于等于请求版本号的版本
        if (version >= this.apiVersion) {
            return this;
        }
        return null;
    }
}
