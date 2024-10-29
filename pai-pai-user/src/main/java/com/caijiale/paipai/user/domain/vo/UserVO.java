package com.caijiale.paipai.user.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户表
 *
 * @author : caijiale
 * @date : 2024-10-25
 */
@Data
public class UserVO implements Serializable {
    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;


}