package com.caijiale.paipai.user.domain.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 用户注册请求参数
 *
 * @author : caijiale
 * @date : 2024-10-25
 */
@Data
public class UserRegisterReq implements Serializable {

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

}