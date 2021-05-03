package cn.f33v.app.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Administrator
 */
@Data
@ApiModel("注册用户视图传输对象")
public class RegisterUserVO {
    @ApiModelProperty(name = "username", value = "用户名", required = true, dataType = "String")
    private String username;
    @ApiModelProperty(name = "password", value = "密码", required = true, dataType = "String")
    private String password;
    @ApiModelProperty(name = "email", value = "邮箱", required = true, dataType = "String")
    private String email;
    @ApiModelProperty(name = "code", value = "验证码", required = true, dataType = "String")
    private String code;
}
