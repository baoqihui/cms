package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 培训安排
 *
 * @author hbq
 * @date 2022-05-06 10:47:17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("trains")
@ApiModel(description = "培训安排")
public class Trains extends SuperEntity {
    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "主题")
        private String title;
        @ApiModelProperty(value = "视频链接")
        private String video;
        @ApiModelProperty(value = "培训开始时间")
        private Date trainStartTime;
        @ApiModelProperty(value = "培训结束时间")
        private Date trainEndTime;
        @ApiModelProperty(value = "视频点击次数")
        private Long clickNum;
        @ApiModelProperty(value = "排序")
        private Integer orders;
}
