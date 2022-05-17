package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 收藏表
 *
 * @author hbq
 * @date 2022-05-14 20:48:45
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("collect")
@ApiModel(description = "收藏表")
public class Collect extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private Long userId;
    @ApiModelProperty(value = "医疗内容id")
    private Long medicalsId;
    @ApiModelProperty(value = "是否收藏（0-未收藏 1-已收藏）")
    private Integer isCollect;
}
