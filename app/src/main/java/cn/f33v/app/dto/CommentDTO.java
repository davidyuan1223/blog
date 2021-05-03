package cn.f33v.app.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@Data
public class CommentDTO {
    private Integer id;
    private Integer userId;
    private String nickname;
    private String avatar;
    private String webSite;
    private Integer likeCount;
    private Date createTime;
    private Integer replyCount;
    private List<ReplyDTO> replyDTOList;
}
