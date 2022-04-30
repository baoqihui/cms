package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 公告
 *
 * @author hbq
 * @date 2022-04-26 18:21:27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("banner")
@ApiModel(description = "公告")
public class Banner extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公告")
    private String name;
}
