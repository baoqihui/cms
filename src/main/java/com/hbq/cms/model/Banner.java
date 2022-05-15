package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 轮播图
 *
 * @author hbq
 * @date 2022-05-15 14:24:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("banner")
@ApiModel(description = "轮播图")
public class Banner extends SuperEntity {
    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "视频id")
    private Long videoId;
        @ApiModelProperty(value = "图片链接")
    private String imgUrl;
}
