package cn.hug.boot.token.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hug.boot.token.service.ISignatureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 签名服务
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-12 15:07
 */
@Slf4j
@Service
public class SignatureService implements ISignatureService {

    /**
     * 签名
     * @param paramBody
     * @param token
     * @param timestamp
     * @return
     */
    @Override
    public String signature(Map<String, Object> paramBody, String token, Long timestamp) {
        paramBody.put("token", token);
        paramBody.put("timestamp", timestamp);

        Map<String, Object> sortMap = sort(paramBody);
        List<String> list = new ArrayList<>();

        sortMap.forEach((k, v) -> list.add(k + "=" +v));

        String urlStr = "";
        for (String key : list) {
            urlStr += "&" + key;
        }
        String signStr = urlStr.substring(1);
        log.info("签名字符串：{}", signStr);

        return SecureUtil.sha256(signStr);
    }

    /**
     * 签名验证
     * @param paramBody
     * @param token
     * @param timestamp
     * @param signature
     * @return
     */
    @Override
    public boolean authSignature(Map<String, Object> paramBody, String token, Long timestamp, String signature) {
        String rightSign = signature(paramBody, token, timestamp);
        return StrUtil.equals(rightSign, signature);
    }

    /**
     * 按字典序排序
     * @param map
     * @return
     */
    private Map<String, Object> sort(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        log.info("排序前：{}", map);
        Map<String, Object> sortMap = new TreeMap<>(new DictionaryOrder());
        sortMap.putAll(map);
        log.info("排序后：{}", sortMap);

        return sortMap;
    }

    /**
     * 字典排序 内部类
     */
    public class DictionaryOrder implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }
}
