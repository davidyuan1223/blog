package cn.f33v.app.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class ReplyDTO {
    private Integer id;
    private Integer parentId;
    private Integer userId;
    private String nickname;
    private String avatar;
    private String webSite;
    private Integer replyId;
    private String replyNickname;
    private String replyWebSite;
    private String commentContent;
    private Integer likeCount;
    private Date createTime;
}
