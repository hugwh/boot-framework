package cn.hug.boot.api.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Map;

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
        if (jsonObject == null) {
            return null;
        }
        String str = JSONObject.toJSONString(jsonObject);
        return toBean(str, clazz);
    }

    /**
     * json转map
     * @param json
     * @return
     */
    public static Map<String, Object> jsonStringToMap(String json) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        return JSON.parseObject(json, Map.class);
    }

    /**
     * map转json
     * @param m
     * @return
     */
    public static JSONObject toJson(Map m) {
        JSONObject json = new JSONObject(m);
        return json;
    }

    /**
     * json转字符串
     * @param jsonObject
     * @return
     */
    public static String toString(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }

        return jsonObject.toJSONString();
    }
}
