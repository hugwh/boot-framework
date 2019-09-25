package cn.hug.boot.api.exception;

import cn.hug.boot.api.enums.ErrCodeEnum;

/**
 * 说明: 统一业务异常返回
 *
 * @author: Liuwb
 * @mail liuwb@txtws.com
 * @date: 2018-10-31 9:56
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -6925278824391495117L;

    private Integer status;

    private String message;

    public BusinessException(ErrCodeEnum errCodeEnum , String message) {
        super(message);
        this.status = errCodeEnum.getCode();
        this.message = message;
    }

    public BusinessException(String message) {
        super(message);
        this.status = ErrCodeEnum.COMMON_ERR.getCode();
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
