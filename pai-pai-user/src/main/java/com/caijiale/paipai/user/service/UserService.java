package com.caijiale.paipai.user.service;


import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.caijiale.paipai.base.page.PageResult;
import com.caijiale.paipai.user.domain.entity.User;
import com.caijiale.paipai.user.domain.request.UserReq;
import com.caijiale.paipai.user.domain.vo.UserVO;

/**
 * 用户表;(user)表服务接口
 *
 * @author : caijiale
 * @date : 2024-10-26
 */
public interface UserService extends IService<User> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Long id);

    /**
     * 分页查询
     *
     * @param userReq 筛选条件
     * @return
     */
    PageResult<UserVO> paginQuery(UserReq userReq);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 更新数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    Boolean register(UserReq userReq);

    SaResult doLogin(UserReq userReq);
}