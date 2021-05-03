package cn.f33v.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2021-04-24 17:08:59
 */
@Data
@ApiModel("角色")
@TableName("role")
public class Role implements Serializable {
    private static final long serialVersionUID = 109143184702251509L;
    /**
     * 角色id
     */
    @ApiModelProperty("角色主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String roleName;
    /**
     * 角色简介
     */
    @ApiModelProperty("角色描述")
    private String description;

}
