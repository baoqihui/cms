package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 药品
 *
 * @author hbq
 * @date 2022-04-23 13:31:59
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("drug")
@ApiModel(description = "药品")
public class Drug extends SuperEntity {
    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "药品名")
        private String name;
}
