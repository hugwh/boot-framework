package cn.hug.boot.api.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * json工具类
 * @author: huangwh
 * @date: 2019/10/31 13:31
 */
public class JsonUtils {

    /**
     * 字符串转json
     * @param str
     * @return
     */
    public static JSONObject toJSON(String str) {
        return JSON.parseObject(str);
    }

    /**
     * 字符串转对象
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toBean(String str, Class<T> clazz) {
        return JSON.parseObject(str, clazz);
    }

    /**
     * json转对象
     * @param jsonObject
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toBean(JSONObject jsonObject, Class<T> clazz) {
        String str = JSONObject.toJSONString(jsonObject);
        return toBean(str, clazz);
    }
}
