package com.caijiale.paipai.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.caijiale.paipai.base.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户表;undefined
 *
 * @author : http://www.chiner.pro
 * @date : 2024-10-25
 */
@Data
@ApiModel(value = "用户表", description = "undefined")
@TableName("user")
public class User extends BaseEntity implements Serializable {
    /**
     * 用户ID
     */
    @ApiModelProperty(name = "用户ID", notes = "")
    @TableId
    private Long id;
    /**
     * 用户名
     */
    @ApiModelProperty(name = "用户名", notes = "")
    private String username;
    /**
     * 用户密码
     */
    @ApiModelProperty(name = "用户密码", notes = "")
    private String password;
    /**
     * 是否删除
     */
    @ApiModelProperty(name = "是否删除", notes = "")
    private String deleted;
    /**
     * 用户角色
     */
    @ApiModelProperty(name = "用户角色", notes = "")
    private String userRole;
    /**
     * 用户登录方式;0 账号密码登录 1微信登录
     */
    @ApiModelProperty(name = "用户登录方式", notes = "0 账号密码登录 1微信登录")
    private String loginType;
    /**
     * 第三方ID
     */
    @ApiModelProperty(name = "第三方ID", notes = "")
    private String openId;
    /**
     * 加密盐
     */
    @ApiModelProperty(name = "加密盐", notes = "")
    private String salt;

}