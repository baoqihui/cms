package com.hbq.cms.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * 用户表
 *
 * @author hbq
 * @date 2022-03-26 12:47:18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账号（编号）")
    @NonNull
    private String account;
    @ApiModelProperty(value = "用户名")
    private String name;
    @NonNull
    @ApiModelProperty(value = "密码")
    private String pwd;
}
