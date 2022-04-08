package com.hbq.cms.vo;

import com.hbq.cms.model.Reply;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReplyVo extends Reply {
    @ApiModelProperty(value = "用户名")
    private String replyName;
}
