package com.hbq.cms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hbq.cms.common.model.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 用户
 *
 * @author hbq
 * @date 2022-05-06 10:47:17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
@ApiModel(description = "用户")
public class User extends SuperEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "手机号码不能为空")
    @NotNull(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "手机号只能为11位")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String account;
    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "密码")
    private String pwd;
    @ApiModelProperty(value = "性别（1-男 2-女）")
    private Integer sex;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "学校")
    private String school;
    @ApiModelProperty(value = "院系")
    private String depa;
    @ApiModelProperty(value = "职级（1-教授/研究员 2-副教授/副研究员 3-讲师/助力研究员 4-其他）")
    private Integer rank;
    @ApiModelProperty(value = "专业id")
    private Long majorId;
    @ApiModelProperty(value = "专业名")
    private String majorName;
    @ApiModelProperty(value = "类型（1-用户 2-管理员）")
    private Integer type;
    @ApiModelProperty(value = "证书编号")
    private String certificateNo;
}
