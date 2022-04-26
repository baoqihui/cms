package com.hbq.cms.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门
 *
 * @author hbq
 * @date 2022-04-26 18:21:27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("depa")
@ApiModel(description = "部门")
public class Depa extends SuperEntity {
    private static final long serialVersionUID=1L;

        @Excel(name = "部门名")
        @ApiModelProperty(value = "部门名")
        private String depaName;
}
