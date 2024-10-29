package com.caijiale.paipai.user.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.caijiale.paipai.base.page.PageResult;
import com.caijiale.paipai.base.response.BaseResponse;
import com.caijiale.paipai.user.domain.entity.User;
import com.caijiale.paipai.user.domain.request.UserReq;
import com.caijiale.paipai.user.domain.vo.UserVO;
import com.caijiale.paipai.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户登录
 *
 * @author : caijiale
 * @date : 2024-10-26
 */
@Api(tags = "用户表对象功能接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户注册
     */
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public BaseResponse<Boolean> register(@RequestBody @Validated UserReq userReq) {
        return BaseResponse.success(userService.register(userReq));
    }

    /**
     * 用户登录
     */
    @ApiOperation("用户登录")
    @PostMapping("/doLogin")
    public BaseResponse<SaResult> doLogin(@RequestBody @Validated UserReq userReq) {
        return BaseResponse.success(userService.doLogin(userReq));
    }

    /**
     * 用户是否登录
     *
     * @return
     */
    @RequestMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping
    public ResponseEntity<User> queryById(Long id) {
        return ResponseEntity.ok(userService.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param userReq 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @PostMapping("/page")
    public BaseResponse<PageResult<UserVO>> paginQuery(@RequestBody UserReq userReq) {
        PageResult<UserVO> pageResult = userService.paginQuery(userReq);
        return BaseResponse.success(pageResult);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(userService.insert(user));
    }

    /**
     * 更新数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public ResponseEntity<User> edit(User user) {
        return ResponseEntity.ok(userService.update(user));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }
}