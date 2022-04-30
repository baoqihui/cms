package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户
 *
 * @author hbq
 * @date 2022-04-04 14:39:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
@ApiModel(description = "用户")
public class User extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工号")
    private String account;
    @ApiModelProperty(value = "昵称")
    private String name;
    @ApiModelProperty(value = "密码")
    private String pwd;
    @ApiModelProperty(value = "性别（1-男 2-女）")
    private Integer sex;
    @ApiModelProperty(value = "部门id")
    private Long depaId;
    @ApiModelProperty(value = "部门名称")
    private String depaName;
    @ApiModelProperty(value = "类型（1-管理员 2-领导 3-员工）")
    private Integer type;
}
