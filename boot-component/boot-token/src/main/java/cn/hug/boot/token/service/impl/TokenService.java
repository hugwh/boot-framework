package cn.hug.boot.token.service.impl;

import cn.hug.boot.api.exception.AuthException;
import cn.hug.boot.token.service.ITokenService;
import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * token服务
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-12 14:46
 */
@Slf4j
@Service
public class TokenService implements ITokenService {

    @Override
    public String create(String uid) {
        String key = new StringBuffer()
                .append(uid)
                .append(new Date().getTime())
                .toString();
        String token = SecureUtil.md5(key);
        //TODO 放入缓存 token:uid

        return token;
    }

    @Override
    public void authentication(String token) {
        //TODO 缓存中取出验证,验证成功返回用户id
//        throw new AuthException("token错误");
//        return null;

        log.info("验证token成功！");
    }
}
