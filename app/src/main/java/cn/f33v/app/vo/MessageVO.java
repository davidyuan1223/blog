package cn.f33v.app.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Administrator
 */
@Data
@ApiModel("留言")
public class MessageVO {
    @ApiModelProperty(name = "nickname", value = "昵称", required = true, dataType = "String")
    private String nickname;
    @ApiModelProperty(name = "avatar", value = "头像", required = true, dataType = "String")
    private String avatar;
    @ApiModelProperty(name = "messageContent", value = "留言内容", dataType = "String")
    private String messageContent;
    @ApiModelProperty(name = "time", value = "弹幕速度", required = true, dataType = "Integer")
    private Integer time;
}
