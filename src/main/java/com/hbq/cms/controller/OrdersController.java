package com.hbq.cms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbq.cms.common.model.PageResult;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.model.Orders;
import com.hbq.cms.service.IOrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 就诊单
 *
 * @author hbq
 * @date 2022-04-23 13:31:59
 */
@Slf4j
@CrossOrigin
@RestController
@Api(tags = "就诊单")
@RequestMapping("orders")
@AllArgsConstructor
public class OrdersController {
    private IOrdersService orderService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    public Result<PageResult> list(@RequestBody Map<String, Object> params) {
        Page<Map> list= orderService.findList(params);
        return Result.succeed(PageResult.restPage(list),"查询成功");
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @PostMapping("/sel/{id}")
    public Result findOrderById(@PathVariable Long id) {
        Orders model = orderService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "新增or更新")
    @PostMapping("/save")
    public Result save(@RequestBody Orders orders) {
        orderService.saveOrUpdate(orders);
        return Result.succeed("保存成功");
    }

    /**
     * 批量新增or更新
     */
    @ApiOperation(value = "批量新增or更新")
    @PostMapping("/saveBatch")
    public Result saveBatch(@RequestBody Map<String,List<Orders>> map) {
        List<Orders> models = map.get("models");
        orderService.saveOrUpdateBatch(models);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除就诊单")
    @PostMapping("/del/{id}")
    public Result delete(@PathVariable Long id) {
        return orderService.delete(id);
    }
}
