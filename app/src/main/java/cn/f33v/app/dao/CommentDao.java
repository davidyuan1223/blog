package cn.f33v.app.dao;

import cn.f33v.app.dto.CommentBackDTO;
import cn.f33v.app.dto.CommentDTO;
import cn.f33v.app.dto.ReplyCountDTO;
import cn.f33v.app.dto.ReplyDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.f33v.app.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Comment)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-24 21:47:01
 */
@Mapper
@Repository
public interface CommentDao extends BaseMapper<Comment> {
    List<CommentDTO> listComments(@Param("articleId") Integer articleId, @Param("current") Integer current);

    List<ReplyDTO> listReplies(@Param("commentIdList") List<Integer> commentIdList);

    List<ReplyCountDTO> listReplyCountByCommentId(@Param("commentIdList") List<Integer> commentIdList);

    List<ReplyDTO> listRepliesByCommentId(@Param("commentId") Integer commentId, @Param("current") Integer current);

    List<CommentBackDTO> getUserReplyList(@Param("current") Integer current, @Param("size") Integer size, @Param("nickname") String nickname);
}
