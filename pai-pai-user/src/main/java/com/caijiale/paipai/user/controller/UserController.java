package com.caijiale.paipai.user.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户表;(user)表控制层
 * @author : http://www.chiner.pro
 * @date : 2024-10-25
 */
@Api(tags = "用户表对象功能接口")
@RestController
@RequestMapping("/user")
public class UserController{

     /**
      * 服务对象
      */
     @GetMapping("/hello")
     @ApiOperation(value = "hello world")
      public String hello() {
          System.out.println("hello world");
          return "hello world";
      }

}