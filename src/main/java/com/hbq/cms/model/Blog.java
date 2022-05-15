package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hbq.cms.common.model.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 笔记
 *
 * @author hbq
 * @date 2022-05-15 14:24:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("blog")
@ApiModel(description = "笔记")
public class Blog extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private Long userId;
    @ApiModelProperty(value = "视频id")
    private Long videoId;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "图片")
    private String imgUrl;
    @ApiModelProperty(value = "内容")
    private String context;
}
