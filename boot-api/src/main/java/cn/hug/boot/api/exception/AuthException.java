package cn.hug.boot.api.exception;

import cn.hug.boot.api.enums.ErrCodeEnum;

/**
 * 权限异常
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-23 15:56
 */
public class AuthException extends BusinessException {
    public AuthException(String message) {
        super(ErrCodeEnum.AUTH_ERR, message);
    }

    public AuthException(ErrCodeEnum errCodeEnum, String message) {
        super(errCodeEnum, message);
    }
}
