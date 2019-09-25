package cn.hug.boot.api.enums;

/**
 * 错误码 枚举类
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-05-23 15:52
 */
public enum ErrCodeEnum {
    COMMON_ERR(-1),   //通用错误
    AUTH_ERR(-100),   //权限异常
    CLIENT_ERR(-200), //连接异常
    PARAM_ERR(-400),  //超时异常
    ;
    private int code;

    ErrCodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
