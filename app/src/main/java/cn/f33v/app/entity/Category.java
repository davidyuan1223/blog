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
 * (Category)实体类
 *
 * @author makejava
 * @since 2021-04-24 17:00:28
 */
@Data
@ApiModel(value = "分类实体类", description = "分类")
@TableName("category")
public class Category implements Serializable {
    private static final long serialVersionUID = -32523702341263564L;
    @ApiModelProperty("分类id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("分类名称")
    private String categoryName;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;

}
