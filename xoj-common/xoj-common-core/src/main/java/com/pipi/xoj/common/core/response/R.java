/**
 * @Time: 2024/3/30 16:17
 * @Author: guoxun
 * @File: CommonResponse
 * @Description:
 */

package com.pipi.xoj.common.core.response;

import lombok.Data;

@Data
public class R<T> {

    // 状态码
    private final Integer status;
    // 返回的数据
    private final T data;
    // 自定义信息
    private final String msg;


    /**
     * 成功
     * @param data 返回的结果
     * @param msg 返回的信息
     * @return
     * @param <T>
     */
    public static <T> R<T> successResponse(T data, String msg){
        return new R<>(ResponseStatus.SUCCESS.getStatus(), data, msg);
    }

    /**
     * 成功的结果
     *
     * @param data 返回结果
     */
    public static <T> R<T> successResponse(T data) {
        return new R<T>(ResponseStatus.SUCCESS.getStatus(), data, "success");
    }

    /**
     * 成功的结果
     *
     * @param msg 返回信息
     */
    public static <T> R<T> successResponse(String msg) {
        return new R<T>(ResponseStatus.SUCCESS.getStatus(), null, msg);
    }

    /**
     * 成功的结果
     */
    public static <T> R<T> successResponse() {
        return new R<T>(ResponseStatus.SUCCESS.getStatus(), null, "success");
    }


    /**
     * 失败的结果，无异常
     *
     * @param msg 返回信息
     */
    public static <T> R<T> errorResponse(String msg) {
        return new R<T>(ResponseStatus.FAIL.getStatus(), null, msg);
    }

    public static <T> R<T> errorResponse(ResponseStatus resultStatus) {
        return new R<T>(resultStatus.getStatus(), null, resultStatus.getDescription());
    }

    public static <T> R<T> errorResponse(String msg, ResponseStatus resultStatus) {
        return new R<T>(resultStatus.getStatus(), null, msg);
    }

    public static <T> R<T> errorResponse(String msg, Integer status) {
        return new R<T>(status, null, msg);
    }

}
