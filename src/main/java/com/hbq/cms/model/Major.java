package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hbq.cms.common.model.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 专业
 *
 * @author hbq
 * @date 2022-05-04 20:15:25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("major")
@ApiModel(description = "专业")
public class Major extends SuperEntity {
    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "部门名")
        private String name;
}
