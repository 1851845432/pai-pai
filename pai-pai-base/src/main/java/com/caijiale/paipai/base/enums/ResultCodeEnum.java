package com.caijiale.paipai.base.enums;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    FAILED(500, "失败");
    public int code;
    public String msg;

    ResultCodeEnum(Integer code, String desc) {
        this.code = code;
        this.msg = desc;
    }

    public static ResultCodeEnum getByCode(int code) {
        for (ResultCodeEnum value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }
}