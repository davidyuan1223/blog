package cn.f33v.app.service.impl;

import cn.f33v.app.dto.*;
import cn.f33v.app.entity.User;
import cn.f33v.app.utils.HtmlUtil;
import cn.f33v.app.utils.UserUtil;
import cn.f33v.app.vo.CommentVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.f33v.app.dao.CommentDao;
import cn.f33v.app.entity.Comment;
import cn.f33v.app.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.*;

/**
 * (Comment)表服务实现类
 *
 * @author makejava
 * @since 2021-04-25 08:32:13
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentDao, Comment> implements CommentService {

    @Override
    public PageDTO<CommentDTO> listComments(Integer articleId, Integer current) {
        //查询文章评论量
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(articleId != null, "article_id", articleId)
                .isNull(articleId == null, "article_id")
                .isNull("parent_id")
                .eq("is_delete", 0);
        Integer commentCount = this.baseMapper.selectCount(queryWrapper);
        if (commentCount == 0) {
            return null;
        }
        //查询评论集合
        List<CommentDTO> commentDTOList = this.baseMapper.listComments(articleId, (current - 1) * 10);
        //点赞量和评论量加入redis后再实现
        List<Integer> commentIdList = new ArrayList<>();
        for (CommentDTO commentDTO : commentDTOList) {
            commentIdList.add(commentDTO.getId());
        }
        //柑橘评论id集合查询所有分页回复数据
        List<ReplyDTO> replyDTOList = this.baseMapper.listReplies(commentIdList);
        List<ReplyCountDTO> replyCountDTOList = this.baseMapper.listReplyCountByCommentId(commentIdList);
        //将回复量封装成评论id对应回复量的map
        Map<Integer, Integer> replyCountMap = new HashMap<>(16);
        for (ReplyCountDTO replyCountDTO : replyCountDTOList) {
            replyCountMap.put(replyCountDTO.getCommentId(), replyCountDTO.getReplyCount());
        }
        //将分页回复数据和回复量封装进对应评论
        for (CommentDTO commentDTO : commentDTOList) {
            List<ReplyDTO> replyDTOS = new ArrayList<>();
            for (ReplyDTO replyDTO : replyDTOList) {
                if (replyDTO.getParentId().equals(commentDTO.getId())) {
                    replyDTOS.add(replyDTO);
                }
            }
            commentDTO.setReplyDTOList(replyDTOS);
            commentDTO.setReplyCount(replyCountMap.get(commentDTO.getId()));
        }
        return new PageDTO<CommentDTO>(commentDTOList, commentCount);
    }

    @Override
    public void saveComment(CommentVO commentVO) {
        //这里要判断一下,看是不是禁言状态,可以根据security获取登录后的用户信息
        //过滤html标签
        commentVO.setCommentContent(HtmlUtil.deleteCommentTag(commentVO.getCommentContent()));
        Comment comment = new Comment();
        //获取当前登录用户id
        User user = UserUtil.getLoginUser();
        assert user != null;
        Integer userId = user.getId();
        comment.setUserId(userId);
        comment.setArticleId(commentVO.getArticleId());
        comment.setCommentContent(commentVO.getCommentContent());
        comment.setParentId(comment.getParentId());
        comment.setReplyId(comment.getReplyId());
        comment.setCreateTime(new Date());
        this.baseMapper.insert(comment);
    }

    @Override
    public List<ReplyDTO> listRepliesByCommentId(Integer commentId, Integer current) {
        return this.baseMapper.listRepliesByCommentId(commentId, (current - 1) * 5);
    }

    @Override
    public List<CommentBackDTO> getUserReplyList(Integer current, Integer size, String nickname) {
        return this.baseMapper.getUserReplyList((current - 1) * size, size, nickname);
    }
}
