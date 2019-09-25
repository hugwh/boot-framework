package cn.hug.boot.api.enums;

public enum ResultEnum {

    OK(0, "success"),
    SYSTEM_ERROR(-999, "未知异常"),
    BUSINESS(-1, "请求失败，请重新提交。"),//业务异常
    ;

    private Integer status;

    private String message;

    ResultEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }


    public String getMessage() {
        return message;
    }

}
