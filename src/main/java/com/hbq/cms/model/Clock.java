package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 打卡
 *
 * @author hbq
 * @date 2022-05-01 09:28:40
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("clock")
@ApiModel(description = "打卡")
public class Clock extends SuperEntity {
    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "用户名")
        private Long userId;
}
