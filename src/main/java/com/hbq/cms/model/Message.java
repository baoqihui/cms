package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 消息/汇报
 *
 * @author hbq
 * @date 2022-04-26 18:21:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("message")
@ApiModel(description = "消息/汇报")
public class Message extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类型（1- 通知 2-汇报）")
    private Integer type;
    @ApiModelProperty(value = "用户id（发送者）")
    private Long userId;
    @ApiModelProperty(value = "接收者id")
    private Long receiveUserId;
    @ApiModelProperty(value = "消息内容")
    private String context;
    @ApiModelProperty(value = "附件")
    private String files;
    @ApiModelProperty(value = "是否读（0-未确认 1-出错 2-已确认）")
    private Integer status;
}
