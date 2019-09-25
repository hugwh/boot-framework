package cn.hug.boot.api.exception;

import cn.hug.boot.api.enums.ErrCodeEnum;

/**
 * 参数异常
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-23 15:55
 */
public class ParamException extends BusinessException {
    public ParamException(String message) {
        super(ErrCodeEnum.PARAM_ERR, message);
    }

    public ParamException(ErrCodeEnum errCodeEnum, String message) {
        super(errCodeEnum, message);
    }
}
