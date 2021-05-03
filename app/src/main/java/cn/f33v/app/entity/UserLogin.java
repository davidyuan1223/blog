package cn.f33v.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserLogin)实体类
 *
 * @author makejava
 * @since 2021-04-24 17:11:38
 */
@Data
@NoArgsConstructor
@ApiModel("用户登录记录对象")
@TableName("user_login")
@AllArgsConstructor
public class UserLogin implements Serializable {
    private static final long serialVersionUID = -57108271614076521L;
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("用户登录主键id")
    private Integer id;
    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("用户登录的ip地址")
    private String ipAddress;
    @ApiModelProperty("用户登录的ip来源")
    private String ipSource;
    @ApiModelProperty("登录类型")
    private String loginType;
    @ApiModelProperty("登录时间")
    private Date loginTime;
    @ApiModelProperty("上次登录时间")
    private Date lastLoginTime;
    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("角色名")
    private String roleName;

}
