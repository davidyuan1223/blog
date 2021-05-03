package cn.f33v.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Api)表实体类
 *
 * @author makejava
 * @since 2021-04-24 16:44:59
 */
@SuppressWarnings("serial")
@Data
@TableName("api")
@ApiModel(value = "API对象", description = "")
@AllArgsConstructor
@NoArgsConstructor
public class Api implements Serializable {
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("apiId")
    private Integer apiId;
    @ApiModelProperty("api")
    private String name;
    @ApiModelProperty("请求地址")
    private String url;
    @ApiModelProperty("请求方式")
    private String method;
    @ApiModelProperty("父id")
    private Integer pid;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("排序")
    private String sort;

}
