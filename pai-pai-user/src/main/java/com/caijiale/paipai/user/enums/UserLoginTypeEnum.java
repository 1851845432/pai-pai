package com.caijiale.paipai.user.enums;

import lombok.Getter;

/**
 * @author MAKABAKA
 */

@Getter
public enum UserLoginTypeEnum {

    PASSWORD(0, "账号密码登录"),
    WX(1, "微信登录");

    private Integer code;
    private String desc;

    UserLoginTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
