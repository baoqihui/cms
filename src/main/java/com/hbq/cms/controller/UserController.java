package com.hbq.cms.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbq.cms.common.model.PageResult;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.dto.UserDto;
import com.hbq.cms.model.User;
import com.hbq.cms.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 用户表
 *
 * @author hbq
 * @date 2022-03-26 12:47:18
 */
@Slf4j
@CrossOrigin
@RestController
@Api(tags = "用户")
@RequestMapping("user")
@AllArgsConstructor
public class UserController {
    private IUserService userService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    public Result<PageResult> list(@RequestBody Map<String, Object> params) {
        Page<Map> list = userService.findList(params);
        return Result.succeed(PageResult.restPage(list), "查询成功");
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @PostMapping("/sel/{id}")
    public Result findUserById(@PathVariable Long id) {
        User model = userService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 登录
     */
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result login(@Valid @RequestBody UserDto userDto, HttpServletResponse response) {
        return userService.login(userDto, response);
    }

    /**
     * 退出登录
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        return userService.logout(request);
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "注册")
    @PostMapping("/register")
    public Result register(@Valid @RequestBody UserDto userDto) {
        return userService.register(userDto);
    }

    /**
     * 修改密码
     */
    @ApiOperation(value = "修改密码")
    @PostMapping("/updatePwd")
    public Result updatePwd(@Valid @RequestBody UserDto userDto) {
        return userService.updatePwd(userDto);
    }

    /**
     * 更新
     */
    @ApiOperation(value = "更新")
    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        if (ObjectUtil.isNull(user.getId())) {
            return Result.failed("请输入id");
        }
        user.setPwd(null);
        userService.updateById(user);
        return Result.succeed("修改成功");
    }

    @ApiOperation(value = "充值")
    @PostMapping("/recharge")
    public Result recharge(@RequestBody User user) {
        if (ObjectUtil.isNull(user.getId())) {
            return Result.failed("请输入id");
        }
        User existUser = userService.getById(user.getId());
        if (ObjectUtil.isNull(existUser)) {
            return Result.failed("用户不存在");
        }
        user.setAmount(existUser.getAmount() + user.getAmount());
        userService.updateById(user);
        return Result.succeed("充值成功");
    }

    @ApiOperation(value = "购买会员")
    @PostMapping("/pay")
    public Result pay(@RequestBody User user) {
        if (ObjectUtil.isNull(user.getId())) {
            return Result.failed("请输入id");
        }
        User existUser = userService.getById(user.getId());
        if (ObjectUtil.isNull(existUser)) {
            return Result.failed("用户不存在");
        }
        if (ObjectUtil.equal(existUser.getIsVip(), 1)) {
            return Result.failed("已是会员");
        }
        if (existUser.getAmount() < 66) {
            return Result.failed("余额不足");
        }
        user.setAmount(existUser.getAmount() - 66);
        user.setIsVip(1);
        userService.updateById(user);
        return Result.succeed(user,"购买成功");
    }

    /**
     * 批量新增or更新
     */
    @ApiOperation(value = "批量新增or更新")
    @PostMapping("/saveBatch")
    public Result saveBatch(@RequestBody Map<String, List<User>> map) {
        List<User> models = map.get("models");
        userService.saveOrUpdateBatch(models);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除")
    @PostMapping("/del")
    public Result delete(@RequestBody Map<String, List<Long>> map) {
        List<Long> ids = map.get("ids");
        userService.removeByIds(ids);
        return Result.succeed("删除成功");
    }
}
