package com.caijiale.paipai.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caijiale.paipai.user.domain.entity.UserInfo;
import com.caijiale.paipai.user.mapper.UserInfoMapper;
import com.caijiale.paipai.user.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * 用户个人信息表(UserInfo)表服务实现类
 *
 * @author caijiale
 * @since 2024-10-29 19:03:25
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}

