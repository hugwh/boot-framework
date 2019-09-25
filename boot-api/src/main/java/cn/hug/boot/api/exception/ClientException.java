package cn.hug.boot.api.exception;

import cn.hug.boot.api.enums.ErrCodeEnum;

/**
 * 服务连接异常
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-23 15:56
 */
public class ClientException extends BusinessException {
    public ClientException(String message) {
        super(ErrCodeEnum.CLIENT_ERR, message);
    }

    public ClientException(ErrCodeEnum errCodeEnum, String message) {
        super(errCodeEnum, message);
    }
}
