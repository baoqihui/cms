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

import com.hbq.cms.model.Reply;
import com.hbq.cms.service.IReplyService;
import com.hbq.cms.common.model.PageResult;
import com.hbq.cms.common.model.Result;

/**
 * 回复
 *
 * @author hbq
 * @date 2022-05-15 14:24:05
 */
@Slf4j
@CrossOrigin
@RestController
@Api(tags = "回复")
@RequestMapping("reply")
@AllArgsConstructor
public class ReplyController {
    private IReplyService replyService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    public Result<PageResult> list(@RequestBody Map<String, Object> params) {
        Page<Map> list= replyService.findList(params);
        return Result.succeed(PageResult.restPage(list),"查询成功");
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @PostMapping("/sel/{id}")
    public Result findReplyById(@PathVariable Long id) {
        Reply model = replyService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "新增or更新")
    @PostMapping("/save")
    public Result save(@RequestBody Reply reply) {
        replyService.saveOrUpdate(reply);
        return Result.succeed("保存成功");
    }

    /**
     * 批量新增or更新
     */
    @ApiOperation(value = "批量新增or更新")
    @PostMapping("/saveBatch")
    public Result saveBatch(@RequestBody Map<String,List<Reply>> map) {
        List<Reply> models = map.get("models");
        replyService.saveOrUpdateBatch(models);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除")
    @PostMapping("/del")
    public Result delete(@RequestBody Map<String,List<Long>> map) {
        List<Long> ids = map.get("ids");
        replyService.removeByIds(ids);
        return Result.succeed("删除成功");
    }
}
