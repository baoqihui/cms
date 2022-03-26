package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import com.hbq.cms.common.model.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 媒体
 *
 * @author hbq
 * @date 2022-03-26 19:40:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("media")
public class Media extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private Long userId;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "内容")
    private String context;
    @ApiModelProperty(value = "文件集合（,分割 音乐和电影单个路径）")
    private String files;
    @ApiModelProperty(value = "类型（1-新闻 2-音乐 3-电影 4-动态）")
    private Boolean type;
}
