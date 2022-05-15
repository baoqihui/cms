package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医疗内容
 *
 * @author hbq
 * @date 2022-05-08 15:04:21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("medicals")
@ApiModel(description = "医疗内容")
public class Medicals extends SuperEntity {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "内容")
    private String context;
    @ApiModelProperty(value = "正文文件")
    private String contextUrl;
    @ApiModelProperty(value = "文件集合")
    private String files;
    @ApiModelProperty(value = "类型（1-典籍 2-经络 3-医方 4-穴位 5-学习笔记）")
    private Integer type;
}
