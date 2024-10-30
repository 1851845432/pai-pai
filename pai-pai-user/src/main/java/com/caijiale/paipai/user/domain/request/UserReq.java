package com.caijiale.paipai.user.domain.request;

import com.caijiale.paipai.base.page.PageRequest;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 用户请求参数
 *
 * @author : caijiale
 * @date : 2024-10-25
 */
@Data
@Validated
public class UserReq extends PageRequest implements Serializable {
    /**
     * 用户ID
     */

    private Long id;
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    @Size(max = 20, min = 6, message = "用户名长度为6-20位")
    private String username;
    /**
     * 用户密码
     */
    @NotBlank(message = "密码不能为空")
    @Size(max = 20, min = 6, message = "密码长度为6-20位")
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