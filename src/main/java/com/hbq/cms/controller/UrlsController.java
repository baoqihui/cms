package com.hbq.cms.controller;
import java.io.IOException;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.servlet.http.HttpServletResponse;


import java.util.Map;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.hbq.cms.model.Urls;
import com.hbq.cms.service.IUrlsService;
import com.hbq.cms.common.model.PageResult;
import com.hbq.cms.common.model.Result;

/**
 * 友情链接表
 *
 * @author hbq
 * @date 2022-05-08 15:04:21
 */
@Slf4j
@CrossOrigin
@RestController
@Api(tags = "友情链接表")
@RequestMapping("urls")
@AllArgsConstructor
public class UrlsController {
    private IUrlsService urlsService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    public Result<PageResult> list(@RequestBody Map<String, Object> params) {
        Page<Map> list= urlsService.findList(params);
        return Result.succeed(PageResult.restPage(list),"查询成功");
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @PostMapping("/sel/{id}")
    public Result findUrlsById(@PathVariable Long id) {
        Urls model = urlsService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "新增or更新")
    @PostMapping("/save")
    public Result save(@RequestBody Urls urls) {
        urlsService.saveOrUpdate(urls);
        return Result.succeed("保存成功");
    }

    /**
     * 批量新增or更新
     */
    @ApiOperation(value = "批量新增or更新")
    @PostMapping("/saveBatch")
    public Result saveBatch(@RequestBody Map<String,List<Urls>> map) {
        List<Urls> models = map.get("models");
        urlsService.saveOrUpdateBatch(models);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除")
    @PostMapping("/del")
    public Result delete(@RequestBody Map<String,List<Long>> map) {
        List<Long> ids = map.get("ids");
        urlsService.removeByIds(ids);
        return Result.succeed("删除成功");
    }
}