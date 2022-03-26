package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 轮播图
 *
 * @author hbq
 * @date 2022-03-26 19:53:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("banner")
public class Banner extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "对应的媒体id")
    private Long mediaId;
    @ApiModelProperty(value = "图片链接")
    private String image;
}
