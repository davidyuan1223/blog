package cn.f33v.app.dto;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class CommentBackDTO {
    private Integer userId;
    private String avatar;
    private String nickname;
    private String replyId;
    private String replyNickname;
    private Integer articleId;
    private String articleTitle;
    private String commentContent;
    private String createTime;
}
