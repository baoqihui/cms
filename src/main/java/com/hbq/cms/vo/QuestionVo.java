package com.hbq.cms.vo;

import com.hbq.cms.model.Reply;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 问题
 *
 * @author hbq
 * @date 2022-04-04 14:39:48
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(description = "问题详情")
@Builder
public class QuestionVo{
    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "用户id")
        private Long userId;
        @ApiModelProperty(value = "问题描述")
        private String title;
        @ApiModelProperty(value = "回复列表")
        private List<Reply> replies;
}
