package cn.hug.boot.token.service;

/**
 * token服务
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-09-12 14:45
 */
public interface ITokenService {
    String create(String uid);

    String authentication(String token);
}
