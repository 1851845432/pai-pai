package com.caijiale.paipai.user.domain.vo;

import com.caijiale.paipai.base.domain.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户表
 *
 * @author : caijiale
 * @date : 2024-10-25
 */
@Data
public class UserVO extends BaseEntity implements Serializable {
    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 是否删除
     */
    private String deleted;
    /**
     * 用户角色
     */
    private String userRole;
    /**
     * 用户登录方式;0 账号密码登录 1微信登录
     */
    private String loginType;
    /**
     * 第三方ID
     */
    private String openId;
    /**
     * 加密盐
     */
    private String salt;

}