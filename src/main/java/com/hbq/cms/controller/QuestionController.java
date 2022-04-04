package com.hbq.cms.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbq.cms.common.model.PageResult;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.model.Question;
import com.hbq.cms.service.IQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 问题
 *
 * @author hbq
 * @date 2022-04-04 14:39:48
 */
@Slf4j
@CrossOrigin
@RestController
@Api(tags = "问题")
@RequestMapping("question")
@AllArgsConstructor
public class QuestionController {
    private IQuestionService questionService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    public Result<PageResult> list(@RequestBody Map<String, Object> params) {
        Page<Map> list= questionService.findList(params);
        return Result.succeed(PageResult.restPage(list),"查询成功");
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @PostMapping("/sel/{id}")
    public Result findDetailById(@PathVariable Long id) {
        return questionService.findDetailById(id);
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "新增or更新")
    @PostMapping("/save")
    public Result save(@RequestBody Question question) {
        questionService.saveOrUpdate(question);
        return Result.succeed("保存成功");
    }

    /**
     * 批量新增or更新
     */
    @ApiOperation(value = "批量新增or更新")
    @PostMapping("/saveBatch")
    public Result saveBatch(@RequestBody Map<String,List<Question>> map) {
        List<Question> models = map.get("models");
        questionService.saveOrUpdateBatch(models);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除")
    @PostMapping("/del/{id}")
    public Result delete(@PathVariable Long id) {
        return questionService.delete(id);
    }
}
