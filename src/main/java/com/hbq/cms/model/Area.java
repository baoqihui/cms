package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hbq.cms.common.model.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 
 *
 * @author hbq
 * @date 2022-05-04 20:49:43
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("area")
@ApiModel(description = "")
public class Area extends SuperEntity {
    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "父节点ID")
        private Integer parent;
        @ApiModelProperty(value = "名字")
        private String name;
        @ApiModelProperty(value = "层级（0-全国 1-省 2-市 3-区）")
        private Integer level;
        @ApiModelProperty(value = "简称")
        private String shortCode;
}
