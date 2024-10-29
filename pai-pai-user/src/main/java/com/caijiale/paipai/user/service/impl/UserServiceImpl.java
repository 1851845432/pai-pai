package com.caijiale.paipai.user.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caijiale.paipai.base.page.PageResult;
import com.caijiale.paipai.commons.enums.BizErrorCodeEnum;
import com.caijiale.paipai.commons.exception.BizException;
import com.caijiale.paipai.user.converter.UserConverter;
import com.caijiale.paipai.user.domain.entity.User;
import com.caijiale.paipai.user.domain.request.UserReq;
import com.caijiale.paipai.user.domain.vo.UserVO;
import com.caijiale.paipai.user.enums.UserLoginTypeEnum;
import com.caijiale.paipai.user.mapper.UserMapper;
import com.caijiale.paipai.user.service.UserService;
import com.caijiale.paipai.user.utils.UserPwdEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.caijiale.paipai.user.constant.UserConstant.COMMON_USER;

/**
 * 用户表;(user)表服务实现类
 *
 * @author : caijiale
 * @date : 2024-10-26
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        User user = userMapper.selectById(id);
        if (user == null) {
            throw new BizException(BizErrorCodeEnum.USER_NOT_EXIST);
        }
        return user;
    }

    /**
     * 分页查询
     *
     * @param userReq 筛选条件
     * @return
     */
    @Override
    public PageResult paginQuery(UserReq userReq) {

        int pageNo = userReq.getPageNo();
        int pageSize = userReq.getPageSize();


        //1. 构建动态查询条件
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        if (StrUtil.isNotBlank(userReq.getUsername())) {
            queryWrapper.eq(User::getUsername, userReq.getUsername());
        }
        if (StrUtil.isNotBlank(userReq.getUserRole())) {
            queryWrapper.eq(User::getUserRole, userReq.getUserRole());
        }
        if (StrUtil.isNotBlank(userReq.getLoginType())) {
            queryWrapper.eq(User::getLoginType, userReq.getLoginType());
        }
        if (StrUtil.isNotBlank(userReq.getOpenId())) {
            queryWrapper.eq(User::getOpenId, userReq.getOpenId());
        }
        if (StrUtil.isNotBlank(userReq.getSalt())) {
            queryWrapper.eq(User::getSalt, userReq.getSalt());
        }
        if (StrUtil.isNotBlank(userReq.getDeleted())) {
            boolean deleted = Boolean.parseBoolean(userReq.getDeleted());
            queryWrapper.eq(User::getDeleted, deleted);
        }

        //2. 执行分页查询
        Page<User> userPage = this.page(new Page<>(pageNo, pageSize, true), queryWrapper);

        //3. 返回结果
        IPage<UserVO> userVOIPage = userPage.convert(UserConverter.INSTANCE::do2UserVO);
        return PageResult.of(userVOIPage);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        userMapper.insert(user);
        return user;
    }

    /**
     * 更新数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<User> chainWrapper = new LambdaUpdateChainWrapper<User>(userMapper);
        if (StrUtil.isNotBlank(user.getUsername())) {
            chainWrapper.eq(User::getUsername, user.getUsername());
        }
        if (StrUtil.isNotBlank(user.getPassword())) {
            chainWrapper.eq(User::getPassword, user.getPassword());
        }
        if (user.getDeleted() != null) {
            chainWrapper.eq(User::getDeleted, user.getDeleted());
        }
        if (StrUtil.isNotBlank(user.getUserRole())) {
            chainWrapper.eq(User::getUserRole, user.getUserRole());
        }
        if (user.getLoginType() != null) {
            chainWrapper.eq(User::getLoginType, user.getLoginType());
        }
        if (StrUtil.isNotBlank(user.getOpenId())) {
            chainWrapper.eq(User::getOpenId, user.getOpenId());
        }
        if (StrUtil.isNotBlank(user.getSalt())) {
            chainWrapper.eq(User::getSalt, user.getSalt());
        }
        //2. 设置主键，并更新
        chainWrapper.set(User::getId, user.getId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if (ret) {
            return queryById(user.getId());
        } else {
            return user;
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        int total = userMapper.deleteById(id);
        return total > 0;
    }

    /**
     * 用户注册
     *
     * @param userReq
     * @return
     */
    @Override
    public Boolean register(UserReq userReq) {
        //1. 校验用户是否已经存在
        LambdaQueryWrapper<User> queryWrapper = new QueryWrapper<User>().lambda()
                .eq(User::getUsername, userReq.getUsername());
        long exits = this.count(queryWrapper);
        if (exits > 0) {
            throw new BizException(BizErrorCodeEnum.USER_IS_EXIST);
        }
        //2. 注册用户，设置默认参数
        String salt = UserPwdEncoderUtil.generateSalt();
        User user = User.builder()
                .username(userReq.getUsername())
                .password(UserPwdEncoderUtil.encode(userReq.getPassword(), salt))
                .userRole(COMMON_USER)
                .loginType(UserLoginTypeEnum.PASSWORD.getCode())
                .salt(salt)
                .build();
        //3. 保存用户
        boolean success = this.save(user);
        if (!success) {
            throw new BizException(BizErrorCodeEnum.SYSTEM_ERROR, "注册失败，数据库插入异常");
        }
        return true;
    }

    @Override
    public SaResult doLogin(UserReq userReq) {
        User user = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getUsername, userReq.getUsername()));
        if (user == null) {
            throw new BizException(BizErrorCodeEnum.USER_NOT_EXIST);
        }
        boolean matches = UserPwdEncoderUtil.matches(userReq.getPassword(), user.getSalt(), user.getPassword());
        if (!matches) {
            throw new BizException(BizErrorCodeEnum.USER_PASSWORD_ERROR);
        }
        StpUtil.login(user.getId());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return SaResult.data(tokenInfo);
    }
}