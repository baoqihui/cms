package com.hbq.cms.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
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

    @Excel(name = "工号")
    @ApiModelProperty(value = "工号")
    private String account;
    @Excel(name = "昵称")
    @ApiModelProperty(value = "昵称")
    private String name;
    @Excel(name = "密码")
    @ApiModelProperty(value = "密码")
    private String pwd;
    @Excel(name = "性别（1-男 2-女）")
    @ApiModelProperty(value = "性别（1-男 2-女）")
    private Integer sex;
    @Excel(name = "部门id")
    @ApiModelProperty(value = "部门id")
    private Long depaId;
    @Excel(name = "类型（1-管理员 2-领导 3-员工）")
    @ApiModelProperty(value = "类型（1-管理员 2-领导 3-员工）")
    private Integer type;
}
