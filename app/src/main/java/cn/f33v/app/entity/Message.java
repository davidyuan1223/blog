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
 * (Message)实体类
 *
 * @author makejava
 * @since 2021-04-24 17:08:58
 */
@Data
@ApiModel("消息对象")
@TableName("message")
public class Message implements Serializable {
    private static final long serialVersionUID = 377802904906697151L;
    @ApiModelProperty("主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("ip地址")
    private String ipAddress;
    @ApiModelProperty("ip地理位置")
    private String ipSource;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("消息内容")
    private String messageContent;
    @ApiModelProperty("弹幕速度")
    private Integer time;
    @ApiModelProperty("创建时间")
    private Date createTime;

}
