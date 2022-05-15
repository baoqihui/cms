package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hbq.cms.common.model.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 用户
 *
 * @author hbq
 * @date 2022-05-15 14:24:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
@ApiModel(description = "用户")
public class User extends SuperEntity {
    private static final long serialVersionUID=1L;

        @ApiModelProperty(value = "账号（用户名）")
    private String account;
        @ApiModelProperty(value = "昵称")
    private String name;
        @ApiModelProperty(value = "密码")
    private String pwd;
        @ApiModelProperty(value = "性别（1-男 2-女）")
    private Integer sex;
        @ApiModelProperty(value = "邮箱")
    private String email;
        @ApiModelProperty(value = "余额")
    private Integer amount;
        @ApiModelProperty(value = "是否会员（0-非会员 1-会员）")
    private Integer isVip;
        @ApiModelProperty(value = "类型（1-用户 2-管理员）")
    private Integer type;
}
