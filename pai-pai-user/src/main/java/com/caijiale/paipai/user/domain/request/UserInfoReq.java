package com.caijiale.paipai.user.domain.request;


import com.caijiale.paipai.base.page.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户个人信息表 请求类
 *
 * @author : caijiale
 * @date : 2024-10-29 19:16:37
 */
@Data
@Builder
@ApiModel(value = "用户个人信息表 请求类")
public class UserInfoReq extends PageRequest implements Serializable {

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像")
    private String photo;

    /**
     * 是否启用;1 启用 0 禁用
     */
    @ApiModelProperty(value = "是否启用;1 启用 0 禁用")
    private Integer enabled;

    /**
     * 个人简介
     */
    @ApiModelProperty(value = "个人简介")
    private String profile;

    /**
     * 性别;0 男 1女 2未知
     */
    @ApiModelProperty(value = "性别;0 男 1女 2未知")
    private Integer sex;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickname;


}
