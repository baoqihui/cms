package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 回复
 *
 * @author hbq
 * @date 2022-04-04 14:39:49
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("reply")
@ApiModel(description = "回复")
public class Reply extends SuperEntity {
    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "回复人id")
        private Long replyUserId;
        @ApiModelProperty(value = "问题id")
        private Long questionId;
        @ApiModelProperty(value = "内容")
        private String context;
}
