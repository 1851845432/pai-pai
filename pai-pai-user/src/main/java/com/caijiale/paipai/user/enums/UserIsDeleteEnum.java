package com.caijiale.paipai.user.enums;

import lombok.Getter;

@Getter
public enum UserIsDeleteEnum {

    DELETED(1, "已删除"),

    UN_DELETED(0, "未删除");

    private Integer code;
    private String desc;

    UserIsDeleteEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
