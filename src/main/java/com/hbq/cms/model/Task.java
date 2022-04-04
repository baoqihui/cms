package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 任务
 *
 * @author hbq
 * @date 2022-04-04 14:39:49
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("task")
@ApiModel(description = "任务")
public class Task extends SuperEntity {
    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "用户id")
        private Long userId;
        @ApiModelProperty(value = "任务名")
        private String title;
        @ApiModelProperty(value = "起始时间")
        private Date startTime;
        @ApiModelProperty(value = "终止时间")
        private Date endTime;
        @ApiModelProperty(value = "状态（0- 否 1-是）")
        private Integer status;
}
