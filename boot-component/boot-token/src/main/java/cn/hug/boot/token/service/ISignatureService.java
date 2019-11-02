package cn.hug.boot.token.service;

import java.util.Map;

/**
 * 签名服务
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-12 15:03
 */
public interface ISignatureService {
    /**
     * 签名
     * @param paramBody
     * @param token
     * @param timestamp
     * @return
     */
    String signature(Map<String, Object> paramBody, String token, String timestamp);

    /**
     * 签名验证
     * @param paramBody
     * @param token
     * @param timestamp
     * @param signature
     */
    void authSignature(Map<String, Object> paramBody, String token, String timestamp, String signature);
}
