package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 问题
 *
 * @author hbq
 * @date 2022-04-04 14:39:48
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("question")
@ApiModel(description = "问题")
public class Question extends SuperEntity {
    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "用户id")
        private Long userId;
        @ApiModelProperty(value = "问题描述")
        private String title;
}
