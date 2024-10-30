package com.caijiale.paipai.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caijiale.paipai.base.page.PageResult;
import com.caijiale.paipai.user.converter.UserInfoConverter;
import com.caijiale.paipai.user.domain.entity.UserInfo;
import com.caijiale.paipai.user.domain.request.UserInfoReq;
import com.caijiale.paipai.user.domain.vo.UserInfoVO;
import com.caijiale.paipai.user.mapper.UserInfoMapper;
import com.caijiale.paipai.user.service.UserInfoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 用户个人信息表(UserInfo)表服务实现类
 *
 * @author caijiale
 * @since 2024-10-29 19:03:25
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Override
    public PageResult<UserInfoVO> paginQuery(UserInfoReq userInfoReq) {
        //1. 构建动态查询条件
        LambdaQueryWrapper<UserInfo> queryWrapper = buildQueryWrapper(userInfoReq);
        //2. 执行分页查询
        Page<UserInfo> userPage = this.page(userInfoReq.toPage(), queryWrapper);
        //3. 返回结果
        IPage<UserInfoVO> userInfoVOIPage = userPage.convert(UserInfoConverter.INSTANCE::do2UserInfoVO);
        return PageResult.of(userInfoVOIPage);

    }

    //根据UserInfoReq的参数构建查询条件
    private LambdaQueryWrapper<UserInfo> buildQueryWrapper(UserInfoReq userInfoReq) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        Optional.ofNullable(userInfoReq.getUserId()).ifPresent(userId -> queryWrapper.eq(UserInfo::getUserId, userId));
        Optional.ofNullable(userInfoReq.getPhone()).ifPresent(phone -> queryWrapper.eq(UserInfo::getPhone, phone));
        Optional.ofNullable(userInfoReq.getEmail()).ifPresent(email -> queryWrapper.eq(UserInfo::getEmail, email));
        Optional.ofNullable(userInfoReq.getPhoto()).ifPresent(photo -> queryWrapper.eq(UserInfo::getPhoto, photo));
        Optional.ofNullable(userInfoReq.getEnabled()).ifPresent(enabled -> queryWrapper.eq(UserInfo::getEnabled, enabled));
        Optional.ofNullable(userInfoReq.getProfile()).ifPresent(profile -> queryWrapper.eq(UserInfo::getProfile, profile));
        Optional.ofNullable(userInfoReq.getSex()).ifPresent(sex -> queryWrapper.eq(UserInfo::getSex, sex));
        Optional.ofNullable(userInfoReq.getNickname()).ifPresent(nickname -> queryWrapper.eq(UserInfo::getNickname, nickname));
        //根据条件构建查询条件
        return queryWrapper;
    }
}

