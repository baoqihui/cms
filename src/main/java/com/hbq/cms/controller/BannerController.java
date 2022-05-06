package com.hbq.cms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbq.cms.common.model.PageResult;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.model.Banner;
import com.hbq.cms.service.IBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 公告
 *
 * @author hbq
 * @date 2022-05-06 10:47:17
 */
@Slf4j
@CrossOrigin
@RestController
@Api(tags = "公告")
@RequestMapping("banner")
@AllArgsConstructor
public class BannerController {
    private IBannerService bannerService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    public Result<PageResult> list(@RequestBody Map<String, Object> params) {
        Page<Map> list= bannerService.findList(params);
        return Result.succeed(PageResult.restPage(list),"查询成功");
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @PostMapping("/sel/{id}")
    public Result findBannerById(@PathVariable Long id) {
        Banner model = bannerService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "新增or更新")
    @PostMapping("/save")
    public Result save(@RequestBody Banner banner) {
        bannerService.saveOrUpdate(banner);
        return Result.succeed("保存成功");
    }

    /**
     * 批量新增or更新
     */
    @ApiOperation(value = "批量新增or更新")
    @PostMapping("/saveBatch")
    public Result saveBatch(@RequestBody Map<String,List<Banner>> map) {
        List<Banner> models = map.get("models");
        bannerService.saveOrUpdateBatch(models);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除")
    @PostMapping("/del")
    public Result delete(@RequestBody Map<String,List<Long>> map) {
        List<Long> ids = map.get("ids");
        bannerService.removeByIds(ids);
        return Result.succeed("删除成功");
    }
}
