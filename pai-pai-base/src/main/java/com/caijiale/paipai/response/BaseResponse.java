package com.caijiale.paipai.response;

import com.caijiale.paipai.enums.ResultCodeEnum;
import lombok.Data;

/**
 * 基础响应类
 *
 * @param <T>
 */
@Data
public class BaseResponse<T> {

    /**
     * 状态码
     */
    private int code;

    /**
     * 提示消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    public static BaseResponse success() {
        return success(null);
    }

    public static <T> BaseResponse success(T data) {
        ResultCodeEnum successCode = ResultCodeEnum.SUCCESS;
        return success(successCode.getCode(), successCode.getMsg(), data);
    }

    public static <T> BaseResponse success(String message, T data) {
        ResultCodeEnum successCode = ResultCodeEnum.SUCCESS;
        return success(successCode.getCode(), message, data);
    }

    public static <T> BaseResponse success(int code, String message, T data) {
        return new BaseResponse(code, message, data);
    }

    public static BaseResponse fail(String message) {
        return fail(ResultCodeEnum.FAILED.getCode(), message);
    }

    public static BaseResponse fail(int code) {
        return fail(code, ResultCodeEnum.FAILED.getMsg());
    }

    public static BaseResponse fail(int code, String message) {
        return fail(code, message, null);
    }

    public static <T> BaseResponse fail(int code, String message, T data) {
        return new BaseResponse(code, message, data);
    }

    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
