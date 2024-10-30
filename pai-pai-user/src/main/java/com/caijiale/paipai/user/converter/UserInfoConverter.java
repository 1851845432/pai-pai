package com.caijiale.paipai.user.converter;

import com.caijiale.paipai.user.domain.entity.UserInfo;
import com.caijiale.paipai.user.domain.vo.UserInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserInfoConverter {
    UserInfoConverter INSTANCE = Mappers.getMapper(UserInfoConverter.class);

    UserInfoVO do2UserInfoVO(UserInfo userInfo);
}
