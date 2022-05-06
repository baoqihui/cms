package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户培训
 *
 * @author hbq
 * @date 2022-05-06 11:49:32
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_trains")
@ApiModel(description = "用户培训")
public class UserTrains extends SuperEntity {
    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "用户id")
        private Long userId;
        @ApiModelProperty(value = "培训id")
        private Long trainsId;
        @ApiModelProperty(value = "状态（0-未观看 1-正在观看 2-已观看）")
        private Integer status;
}
