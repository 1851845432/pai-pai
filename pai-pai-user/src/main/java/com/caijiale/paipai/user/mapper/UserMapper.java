package com.caijiale.paipai.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caijiale.paipai.user.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表;(user)表数据库访问层
 *
 * @author : caijiale
 * @date : 2024-10-26
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}