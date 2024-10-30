package com.caijiale.paipai.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.caijiale.paipai.base.page.PageResult;
import com.caijiale.paipai.user.domain.entity.UserInfo;
import com.caijiale.paipai.user.domain.request.UserInfoReq;
import com.caijiale.paipai.user.domain.vo.UserInfoVO;

/**
 * 用户个人信息表(UserInfo)表服务接口
 *
 * @author caijiale
 * @since 2024-10-29 19:03:25
 */
public interface UserInfoService extends IService<UserInfo> {

    PageResult<UserInfoVO> paginQuery(UserInfoReq userInfoReq);
}

