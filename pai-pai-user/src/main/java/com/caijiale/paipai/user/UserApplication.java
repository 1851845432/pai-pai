package com.caijiale.paipai.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.caijiale.paipai.user", "com.caijiale.paipai.commons"})
@MapperScan("com.caijiale.paipai.user.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
        System.out.println("接口文档地址：http://localhost:8080/doc.html");
    }
}
