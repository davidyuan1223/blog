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
 * (FriendLink)实体类
 *
 * @author makejava
 * @since 2021-04-24 17:04:24
 */
@ApiModel(value = "FriendLink实体", description = "友链")
@Data
@TableName("friend_link")
public class FriendLink implements Serializable {
    private static final long serialVersionUID = -64579318342863046L;
    @ApiModelProperty("主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("友链名称")
    private String linkName;
    @ApiModelProperty("友链头像")
    private String linkAvatar;
    @ApiModelProperty("友链地址")
    private String linkAddress;
    @ApiModelProperty("友链简介")
    private String linkIntro;
    @ApiModelProperty("创建时间")
    private Date createTime;


}
