package cn.hug.boot.token.service.impl;

import cn.hug.boot.token.service.ITokenService;
import cn.hutool.crypto.SecureUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * token服务
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-12 14:46
 */
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
    public String authentication(String token) {
        //TODO 缓存中取出验证,验证成功返回用户id

        return null;
    }
}
