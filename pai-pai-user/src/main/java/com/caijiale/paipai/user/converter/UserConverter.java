package com.caijiale.paipai.user.converter;

import com.caijiale.paipai.user.domain.entity.User;
import com.caijiale.paipai.user.domain.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserVO do2UserVO(User user);
}
