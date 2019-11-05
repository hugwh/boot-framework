package cn.hug.boot.api.util;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * http工具类
 * @author: huangwh
 * @date: 2019/10/31 13:26
 */
public class HttpUtils {

    public static JSONObject get(String url) {
        String result = HttpUtil.get(url);
        return JSON.parseObject(result);
    }

    public static <T> T get(String url, Class<T> clazz) {
        String result = HttpUtil.get(url);
        T t = JsonUtils.stringToBean(result, clazz);
        return t;
    }
}
