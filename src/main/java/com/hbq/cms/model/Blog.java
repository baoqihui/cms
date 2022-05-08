package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 笔记
 *
 * @author hbq
 * @date 2022-05-08 15:04:20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("blog")
@ApiModel(description = "笔记")
public class Blog extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private Long userId;
    @ApiModelProperty(value = "医疗内容id")
    private Long medicalsId;
    @ApiModelProperty(value = "内容")
    private String context;
}
