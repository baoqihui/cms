package com.hbq.cms.common.controller;

import com.hbq.cms.common.model.MessageDTO;
import com.hbq.cms.common.model.Result;
import com.hbq.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: huibq
 * @Date: 2022/5/6 16:11
 * @Description: 公共方法
 */
@RestController
@Api(tags = "公共方法")
@AllArgsConstructor
public class CommonController {
    private MessageUtil messageUtil;

    @ApiOperation(value = "发送短信")
    @PostMapping(value="/sendMessage")
    public Result sendMessage(@Valid @RequestBody MessageDTO messageDTO){
        messageUtil.sendMessage(messageDTO.getTel());
        return Result.succeed("发送成功");
    }

    @ApiOperation(value = "验证短信验证码")
    @PostMapping(value="/check")
    public Result checkMessage(@Valid @RequestBody MessageDTO messageDTO){
        if(messageUtil.isCode(messageDTO.getTel(),messageDTO.getCode())){
            return Result.succeed("验证成功");
        }else{
            return Result.failed("验证失败");
        }
    }
}
