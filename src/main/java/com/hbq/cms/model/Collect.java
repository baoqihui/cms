package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hbq.cms.common.model.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 收藏表
 *
 * @author hbq
 * @date 2022-05-15 14:24:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("collect")
@ApiModel(description = "收藏表")
public class Collect extends SuperEntity {
    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "用户id")
    private Long userId;
        @ApiModelProperty(value = "视频id")
    private Long videoId;
        @ApiModelProperty(value = "是否收藏（0-未收藏 1-已收藏）")
    private Integer isCollect;
}
