package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hbq.cms.common.model.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 视频
 *
 * @author hbq
 * @date 2022-05-15 14:24:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("video")
@ApiModel(description = "视频")
public class Video extends SuperEntity {
    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "课程名")
    private String name;
        @ApiModelProperty(value = "课程主图")
    private String imgUrl;
        @ApiModelProperty(value = "课程视频")
    private String videoUrl;
        @ApiModelProperty(value = "类别（1-java 2-Python 3-大数据 4-C 5-C#）")
    private Integer type;
        @ApiModelProperty(value = "简介")
    private String info;
        @ApiModelProperty(value = "讲师")
    private String teacher;
        @ApiModelProperty(value = "属性（0-免费 1-会员）")
    private Integer isVip;
        @ApiModelProperty(value = "点击次数")
    private Integer clickNum;
}
