package com.hbq.cms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbq.cms.common.model.PageResult;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.common.model.TrainsStatus;
import com.hbq.cms.model.UserTrains;
import com.hbq.cms.service.IUserTrainsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户培训
 *
 * @author hbq
 * @date 2022-05-06 11:49:32
 */
@Slf4j
@CrossOrigin
@RestController
@Api(tags = "用户培训")
@RequestMapping("userTrains")
@AllArgsConstructor
public class UserTrainsController {
    private IUserTrainsService userTrainsService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    public Result<PageResult> list(@RequestBody Map<String, Object> params) {
        Page<Map> list = userTrainsService.findList(params);
        return Result.succeed(PageResult.restPage(list), "查询成功");
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @PostMapping("/sel/{id}")
    public Result findUserTrainsById(@PathVariable Long id) {
        UserTrains model = userTrainsService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "新增or更新")
    @PostMapping("/save")
    public Result save(@RequestBody UserTrains userTrains) {
        userTrainsService.saveOrUpdate(userTrains);
        return Result.succeed("保存成功");
    }

    /**
     * 批量新增or更新
     */
    @ApiOperation(value = "批量新增or更新")
    @PostMapping("/saveBatch")
    public Result saveBatch(@RequestBody Map<String, List<UserTrains>> map) {
        List<UserTrains> models = map.get("models");
        userTrainsService.saveOrUpdateBatch(models);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除")
    @PostMapping("/del")
    public Result delete(@RequestBody Map<String, List<Long>> map) {
        List<Long> ids = map.get("ids");
        userTrainsService.removeByIds(ids);
        return Result.succeed("删除成功");
    }

    /**
     * 判断用户是否已经完成培训
     */
    @ApiOperation(value = "判断用户是否已经完成培训")
    @PostMapping("/isTrain/{userId}")
    public Result isTrain(@PathVariable String userId) {
        int allCount = userTrainsService.count(new LambdaQueryWrapper<UserTrains>()
                .eq(UserTrains::getUserId, userId));
        int count = userTrainsService.count(new LambdaQueryWrapper<UserTrains>()
                .eq(UserTrains::getUserId, userId)
                .eq(UserTrains::getStatus, TrainsStatus.END.getCode()));
        return Result.succeed(allCount == count);
    }
}
