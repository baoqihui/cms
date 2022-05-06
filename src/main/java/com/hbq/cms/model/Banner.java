package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hbq.cms.common.model.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 公告
 *
 * @author hbq
 * @date 2022-05-06 10:47:17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("banner")
@ApiModel(description = "公告")
public class Banner extends SuperEntity {
    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "标题")
        private String name;
        @ApiModelProperty(value = "文件内容 （pdf）")
        private String file;
}
