package cn.f33v.app.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Administrator
 */
@Data
@ApiModel("评论")
public class CommentVO {
    @ApiModelProperty(name = "replyId", value = "回复用户id", dataType = "Integer")
    private Integer replyId;
    @ApiModelProperty(name = "articleId", value = "文章id", dataType = "Integer")
    private Integer articleId;
    @ApiModelProperty(name = "commentContent", value = "评论内容", required = true, dataType = "String")
    private String commentContent;
    @ApiModelProperty(name = "parentId", value = "评论父id", dataType = "Integer")
    private Integer parentId;
}
