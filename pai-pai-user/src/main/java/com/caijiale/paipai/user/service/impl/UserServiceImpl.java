package com.caijiale.paipai.user.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caijiale.paipai.base.page.PageRequest;
import com.caijiale.paipai.base.page.PageResult;
import com.caijiale.paipai.user.converter.UserConverter;
import com.caijiale.paipai.user.domain.entity.User;
import com.caijiale.paipai.user.domain.request.UserReq;
import com.caijiale.paipai.user.domain.vo.UserVO;
import com.caijiale.paipai.user.mapper.UserMapper;
import com.caijiale.paipai.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return this.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param userReq 筛选条件
     * @return
     */
    @Override
    public PageResult paginQuery(UserReq userReq) {
        if (userReq == null || userReq.getPageRequest() == null) {
            throw new IllegalArgumentException("请求参数不能为空");
        }

        PageRequest pageRequest = userReq.getPageRequest();
        int pageNo = pageRequest.getPageNo();
        int pageSize = pageRequest.getPageSize();


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

    @Override
    public Object register(UserReq userReq) {
        return null;
    }
}