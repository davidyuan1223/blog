package cn.f33v.app.service;

import cn.f33v.app.dto.CommentBackDTO;
import cn.f33v.app.dto.CommentDTO;
import cn.f33v.app.dto.PageDTO;
import cn.f33v.app.dto.ReplyDTO;
import cn.f33v.app.vo.CommentVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.f33v.app.entity.Comment;

import java.util.List;

/**
 * (Comment)表服务接口
 *
 * @author makejava
 * @since 2021-04-25 08:52:44
 */
public interface CommentService extends IService<Comment> {
    PageDTO<CommentDTO> listComments(Integer articleId, Integer current);

    void saveComment(CommentVO commentVO);

    List<ReplyDTO> listRepliesByCommentId(Integer commentId, Integer current);

    List<CommentBackDTO> getUserReplyList(Integer current, Integer size, String nickname);
}
