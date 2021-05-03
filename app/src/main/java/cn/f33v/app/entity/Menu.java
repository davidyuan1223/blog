package cn.f33v.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * (Menu)实体类
 *
 * @author makejava
 * @since 2021-04-24 17:06:14
 */
@ApiModel(value = "菜单", description = "菜单")
@Data
@TableName("menu")
public class Menu implements Serializable {
    private static final long serialVersionUID = 276385350827616506L;
    @ApiModelProperty("主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("菜单列表名称")
    private String menuName;
    @ApiModelProperty("菜单url")
    private String menuUrl;
    @ApiModelProperty("菜单父id")
    private Integer parentId;
    @ApiModelProperty("菜单的排序")
    private Integer menuSort;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("菜单的图标")
    private String menuIcon;


}
