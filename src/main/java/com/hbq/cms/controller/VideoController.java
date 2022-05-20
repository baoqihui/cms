package com.hbq.cms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbq.cms.common.model.PageResult;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.model.Video;
import com.hbq.cms.service.IVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 视频
 *
 * @author hbq
 * @date 2022-05-15 14:24:05
 */
@Slf4j
@CrossOrigin
@RestController
@Api(tags = "视频")
@RequestMapping("video")
@AllArgsConstructor
public class VideoController {
    private IVideoService videoService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    public Result<PageResult> list(@RequestBody Map<String, Object> params) {
        Page<Map> list= videoService.findList(params);
        return Result.succeed(PageResult.restPage(list),"查询成功");
    }

    @ApiOperation(value = "观看视频")
    @PostMapping("/see/{videoId}/{userId}")
    public Result findVideoById(@PathVariable Long videoId,@PathVariable Long userId) {
        return videoService.getDetail(videoId,userId);
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "新增or更新")
    @PostMapping("/save")
    public Result save(@RequestBody Video video) {
        videoService.saveOrUpdate(video);
        return Result.succeed("保存成功");
    }

    /**
     * 批量新增or更新
     */
    @ApiOperation(value = "批量新增or更新")
    @PostMapping("/saveBatch")
    public Result saveBatch(@RequestBody Map<String,List<Video>> map) {
        List<Video> models = map.get("models");
        videoService.saveOrUpdateBatch(models);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除")
    @PostMapping("/del")
    public Result delete(@RequestBody Map<String,List<Long>> map) {
        List<Long> ids = map.get("ids");
        videoService.removeByIds(ids);
        return Result.succeed("删除成功");
    }
}