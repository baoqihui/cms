package com.hbq.cms.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbq.cms.common.model.PageResult;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.model.Collect;
import com.hbq.cms.service.ICollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 收藏表
 *
 * @author hbq
 * @date 2022-05-15 14:24:05
 */
@Slf4j
@CrossOrigin
@RestController
@Api(tags = "收藏表")
@RequestMapping("collect")
@AllArgsConstructor
public class CollectController {
    private ICollectService collectService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    public Result<PageResult> list(@RequestBody Map<String, Object> params) {
        Page<Map> list= collectService.findList(params);
        return Result.succeed(PageResult.restPage(list),"查询成功");
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @PostMapping("/sel/{id}")
    public Result findCollectById(@PathVariable Long id) {
        Collect model = collectService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "新增or更新")
    @PostMapping("/save")
    public Result save(@RequestBody Collect collect) {
        collectService.saveOrUpdate(collect);
        return Result.succeed("保存成功");
    }

    /**
     * 获取是否点赞
     */
    @ApiOperation(value = "获取是否点赞")
    @PostMapping("/getCollect")
    public Result getCollect(@RequestBody Collect collect) {
        Collect one = collectService.getOne(new LambdaQueryWrapper<Collect>()
                .eq(Collect::getUserId, collect.getUserId())
                .eq(Collect::getVideoId, collect.getVideoId()));
        if (ObjectUtil.isNull(one) || ObjectUtil.equal(0, one.getIsCollect())) {
            return Result.succeed(false, "未收藏");
        }
        return Result.succeed(true,"已收藏");
    }

    /**
     * 批量新增or更新
     */
    @ApiOperation(value = "批量新增or更新")
    @PostMapping("/saveBatch")
    public Result saveBatch(@RequestBody Map<String,List<Collect>> map) {
        List<Collect> models = map.get("models");
        collectService.saveOrUpdateBatch(models);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除")
    @PostMapping("/del")
    public Result delete(@RequestBody Map<String,List<Long>> map) {
        List<Long> ids = map.get("ids");
        collectService.removeByIds(ids);
        return Result.succeed("删除成功");
    }
}
