package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 就诊单
 *
 * @author hbq
 * @date 2022-04-23 13:31:59
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("orders")
@ApiModel(description = "就诊单")
public class Orders extends SuperEntity {
    private static final long serialVersionUID=1L;
        @ApiModelProperty(value = "用户id")
        private Long userId;
        @ApiModelProperty(value = "医生用户id")
        private Long doctorUserId;
        @ApiModelProperty(value = "就诊建议")
        private String context;
        @ApiModelProperty(value = "药品列表(,分割)")
        private String drugs;
        @ApiModelProperty(value = "状态(1-新建 2-完成)")
        private Integer status;
}
