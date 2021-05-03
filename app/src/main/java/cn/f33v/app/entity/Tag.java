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
 * (Tag)实体类
 *
 * @author makejava
 * @since 2021-04-24 17:08:59
 */
@Data
@ApiModel("Tag 标签对象")
@TableName("tag")
public class Tag implements Serializable {
    private static final long serialVersionUID = 729227457664939916L;
    @ApiModelProperty("标签主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("标签名字")
    private String tagName;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;

}
