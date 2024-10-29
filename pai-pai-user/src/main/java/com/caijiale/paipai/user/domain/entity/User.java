package com.caijiale.paipai.user.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.caijiale.paipai.base.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户表
 *
 * @author : caijiale
 * @date : 2024-10-25
 */

@Data
@Builder
@ApiModel(value = "用户表")
@TableName("user")
public class User extends BaseEntity implements Serializable {
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID", notes = "")
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", notes = "")
    private String username;
    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码", notes = "")
    private String password;
    /**
     * 用户角色
     */
    @ApiModelProperty(value = "用户角色", notes = "admin 管理员 common 普通用户")
    private String userRole;
    /**
     * 用户登录方式;0 账号密码登录 1微信登录
     */
    @ApiModelProperty(value = "用户登录方式", notes = "0 账号密码登录 1微信登录")
    private Integer loginType;
    /**
     * 第三方ID
     */
    @ApiModelProperty(value = "第三方ID", notes = "")
    private String openId;
    /**
     * 加密盐
     */
    @ApiModelProperty(value = "加密盐", notes = "")
    private String salt;

}