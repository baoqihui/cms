package com.hbq.cms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;


/**
 * 媒体
 *
 * @author hbq
 * @date 2022-03-26 19:40:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MediaDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "媒体id（更新时传入）")
    private Long id;
    @ApiModelProperty(value = "用户id")
    @NonNull
    private Long userId;
    @ApiModelProperty(value = "标题")
    @NonNull
    private String title;
    @ApiModelProperty(value = "内容")
    private String context;
    @ApiModelProperty(value = "文件集合（,分割 音乐和电影单个路径）")
    private String files;
    @NonNull
    @ApiModelProperty(value = "类型（1-新闻 2-音乐 3-电影 4-动态）")
    private Integer type;
}
