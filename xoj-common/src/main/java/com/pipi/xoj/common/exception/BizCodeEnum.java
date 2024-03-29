package com.pipi.xoj.common.exception;

/**
 * 系统错误状态码:
 * 10: 通用
 *  - 000: 系统未知异常
 *  - 001: 参数校验失败
 *
 */
public enum BizCodeEnum {
    UNKNOW_EXCEPTION(10000, "Unknow exception"),
    VALID_EXCEPTION(10001, "Parameter check failure");

    private int code;
    private String msg;

    BizCodeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
