package com.hbq.cms.common.controller;

import com.hbq.cms.common.model.Result;
import com.hbq.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result sendMessage(String tel){
        messageUtil.sendMessage(tel);
        return Result.succeed("发送成功");
    }

    @ApiOperation(value = "验证短信验证码")
    @PostMapping(value="/check")
    public Result checkMessage(String tel,String code){
        if(messageUtil.isCode(tel,code)){
            return Result.succeed("验证成功");
        }else{
            return Result.failed("验证失败");
        }
    }
}
