package com.hbq.cms.dto;

import com.hbq.cms.model.User;
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
public class UserDto extends User {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "修改密码")
    private String newPwd;
    @ApiModelProperty(value = "验证码")
    private String code;
    @ApiModelProperty(value = "验证码类型")
    private Integer codeType;
}
