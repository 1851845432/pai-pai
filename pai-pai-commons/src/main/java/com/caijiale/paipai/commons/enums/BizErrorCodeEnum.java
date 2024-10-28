package com.caijiale.paipai.commons.enums;


import lombok.Getter;

import java.util.Objects;


/**
 * 业务错误码
 *
 * @author zhouzhou
 * @version $Id: BusinessErrorCodeEnum.java, v 0.1 2016年4月28日 下午5:44:00 zhouzhou Exp $
 */
@Getter
public enum BizErrorCodeEnum {

    //用户相关异常
    USER_IS_EXIST(1000, "用户已存在"),

    USER_NOT_EXIST(1001, "用户不存在"),

    USER_PASSWORD_ERROR(1002, "用户密码错误"),

    //请求参数校验异常
    PARAMETER_ERROR(1500, "请求参数校验异常"),


    //系统相关异常
    SYSTEM_ERROR(2000, "系统异常"),

    //未知异常
    UNKNOWN(500, "系统未知异常，请联系管理员"),


    ;

    /**
     * 错误码
     */
    private final int code;

    /**
     * 描述
     */
    private final String message;

    /**
     * @param code    错误码
     * @param message 错误信息
     */
    BizErrorCodeEnum(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据编码查询枚举。
     *
     * @param code 编码。
     * @return 枚举。
     */
    public static BizErrorCodeEnum getByCode(int code) {
        for (BizErrorCodeEnum value : BizErrorCodeEnum.values()) {
            if (Objects.equals(code, value.getCode())) {
                return value;
            }
        }
        return UNKNOWN;
    }

    /**
     * 枚举是否包含此code
     *
     * @param code 枚举code
     * @return 结果
     */
    public static Boolean contains(int code) {
        for (BizErrorCodeEnum value : BizErrorCodeEnum.values()) {
            if (Objects.equals(code, value.getCode())) {
                return true;
            }
        }
        return false;
    }
}