package com.hbq.cms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbq.cms.common.model.PageResult;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.model.Trains;
import com.hbq.cms.service.ITrainsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 培训安排
 *
 * @author hbq
 * @date 2022-05-06 10:47:17
 */
@Slf4j
@CrossOrigin
@RestController
@Api(tags = "培训安排")
@RequestMapping("trains")
@AllArgsConstructor
public class TrainsController {
    private ITrainsService trainsService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    public Result<PageResult> list(@RequestBody Map<String, Object> params) {
        Page<Map> list= trainsService.findList(params);
        return Result.succeed(PageResult.restPage(list),"查询成功");
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @PostMapping("/sel/{id}")
    public Result findTrainsById(@PathVariable Long id) {
        Trains model = trainsService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    @ApiOperation(value = "培训次数增加")
    @PostMapping("/click/{id}")
    public Result check(@PathVariable Long id) {
        Trains model = trainsService.getById(id);
        model.setClickNum(model.getClickNum()+1);
        trainsService.updateById(model);
        return Result.succeed("点击量增加成功");
    }
    /**
     * 新增or更新
     */
    @ApiOperation(value = "新增or更新")
    @PostMapping("/save")
    public Result save(@RequestBody Trains trains) {
        trainsService.saveOrUpdate(trains);
        return Result.succeed("保存成功");
    }

    /**
     * 批量新增or更新
     */
    @ApiOperation(value = "批量新增or更新")
    @PostMapping("/saveBatch")
    public Result saveBatch(@RequestBody Map<String,List<Trains>> map) {
        List<Trains> models = map.get("models");
        trainsService.saveOrUpdateBatch(models);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除")
    @PostMapping("/del")
    public Result delete(@RequestBody Map<String,List<Long>> map) {
        List<Long> ids = map.get("ids");
        trainsService.removeByIds(ids);
        return Result.succeed("删除成功");
    }
}
