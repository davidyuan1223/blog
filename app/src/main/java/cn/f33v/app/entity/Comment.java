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
 * (Comment)实体类
 *
 * @author makejava
 * @since 2021-04-24 17:02:21
 */
@Data
@TableName("comment")
@ApiModel(value = "Comment实体", description = "讨论,留言")
public class Comment implements Serializable {
    private static final long serialVersionUID = 409491018795831270L;
    @ApiModelProperty("评论主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("文章id")
    private Integer articleId;
    @ApiModelProperty("评论内容")
    private String commentContent;
    @ApiModelProperty("评论时间")
    private Date createTime;
    @ApiModelProperty("回复的用户id")
    private Integer replyId;
    @ApiModelProperty("父评论id")
    private Integer parentId;
    @ApiModelProperty("是否删除")
    private Boolean isDelete;

}
