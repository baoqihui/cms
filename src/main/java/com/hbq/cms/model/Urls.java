package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 友情链接表
 *
 * @author hbq
 * @date 2022-05-08 15:04:21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("urls")
@ApiModel(description = "友情链接表")
public class Urls extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "友链")
    private String name;
    @ApiModelProperty(value = "友情链接")
    private String url;
}
