package com.hbq.cms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbq.cms.common.model.PageResult;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.dto.MediaDto;
import com.hbq.cms.model.Media;
import com.hbq.cms.service.IMediaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 媒体
 *
 * @author hbq
 * @date 2022-03-26 19:40:25
 */
@Slf4j
@CrossOrigin
@RestController
@Api(tags = "媒体")
@RequestMapping("media")
@AllArgsConstructor
public class MediaController {
    private IMediaService mediaService;

    /**
     * 分享
     */
    @ApiOperation(value = "分享")
    @PostMapping("/share")
    public Result share(@RequestBody MediaDto mediaDto) {
        return mediaService.share(mediaDto);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    public Result<PageResult> list(@RequestBody Map<String, Object> params) {
        Page<Map> list = mediaService.findList(params);
        return Result.succeed(PageResult.restPage(list), "查询成功");
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @PostMapping("/sel/{id}")
    public Result findUserById(@PathVariable Long id) {
        Media model = mediaService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "新增or更新")
    @PostMapping("/save")
    public Result save(@RequestBody Media media) {
        mediaService.saveOrUpdate(media);
        return Result.succeed("保存成功");
    }

    /**
     * 批量新增or更新
     */
    @ApiOperation(value = "批量新增or更新")
    @PostMapping("/saveBatch")
    public Result saveBatch(@RequestBody Map<String, List<Media>> map) {
        List<Media> models = map.get("models");
        mediaService.saveOrUpdateBatch(models);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除")
    @PostMapping("/del")
    public Result delete(@RequestBody Map<String, List<Long>> map) {
        List<Long> ids = map.get("ids");
        mediaService.removeByIds(ids);
        return Result.succeed("删除成功");
    }
}
