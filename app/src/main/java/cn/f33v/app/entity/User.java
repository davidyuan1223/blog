package cn.f33v.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-04-24 17:08:59
 */
@Data
@ApiModel("User 用户对象")
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = -66461016142785160L;
    /**
     * 用户表主键
     */
    @ApiModelProperty("用户主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickname;
    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;
    /**
     * 简介
     */
    @ApiModelProperty("简介")
    private String intro;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;
    /**
     * 0:可用,1:逻辑删除
     */
    @ApiModelProperty("是否删除")
    private Boolean isDelete;
    /**
     * 0:不禁言,1:禁言
     */
    @ApiModelProperty("是否禁言")
    private Boolean isSilence;


}
