package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户表
 *
 * @author hbq
 * @date 2022-03-26 12:47:18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账号（编号）")
    private String account;
    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "密码")
    private String pwd;
}
