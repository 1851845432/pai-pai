package com.caijiale.paipai.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caijiale.paipai.base.page.PageResult;
import com.caijiale.paipai.base.response.BaseResponse;
import com.caijiale.paipai.user.domain.entity.UserInfo;
import com.caijiale.paipai.user.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户个人信息表 对象功能接口
 *
 * @author : caijiale
 * @date : 2024-10-29 19:03:25
 */
@RestController
@RequestMapping("userInfo")
public class UserInfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;

    /**
     * 分页查询
     */
    @ApiOperation("分页查询")
    @PostMapping("/page")
    public BaseResponse<PageResult<UserInfo>> paginQuery(@RequestBody UserInfo userInfo) {
        return BaseResponse.success(this.userInfoService.page(new Page<>(), new QueryWrapper<>(userInfo)));
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping
    public BaseResponse<UserInfo> queryById(Long id) {
        return BaseResponse.success(this.userInfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param userInfo 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping
    public BaseResponse<UserInfo> add(@RequestBody UserInfo userInfo) {
        return BaseResponse.success(this.userInfoService.save(userInfo));
    }

    /**
     * 更新数据
     *
     * @param userInfo 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping
    public BaseResponse<UserInfo> edit(@RequestBody UserInfo userInfo) {
        return BaseResponse.success(this.userInfoService.updateById(userInfo));
    }

    /**
     * 通过主键删除数据
     *
     * @param idList 主键列表
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping
    public BaseResponse<Boolean> deleteByIds(@RequestParam("idList") List<Long> idList) {
        return BaseResponse.success(this.userInfoService.removeByIds(idList));
    }
}
