package cn.f33v.app.controller;

import cn.f33v.app.dto.CommentBackDTO;
import cn.f33v.app.dto.CommentDTO;
import cn.f33v.app.dto.PageDTO;
import cn.f33v.app.dto.ReplyDTO;
import cn.f33v.app.service.impl.CommentServiceImpl;
import cn.f33v.app.vo.CommentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.f33v.app.result.Result;

import java.util.List;

/**
 * @author Administrator
 */
@RestController
@Api("评论模块")
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @ApiOperation("查询评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "articleId", value = "文章id", required = true),
            @ApiImplicitParam(name = "current", value = "当前页面", required = true)
    })
    @GetMapping("/comments")
    public Result listComments(@RequestParam(value = "articleId") Integer articleId,
                               @RequestParam(value = "current") Integer current) {
        PageDTO<CommentDTO> data = commentService.listComments(articleId, current);
        return Result.ok().data("data", data);
    }

    @ApiOperation("添加评论或回复")
    @PostMapping("/comments")
    public Result saveComment(@RequestBody CommentVO commentVO) {
        commentService.saveComment(commentVO);
        return Result.ok();
    }

    @ApiOperation("查看回复评论")
    @GetMapping("/comments/replies")
    public Result listRepliesByCommentId(Integer commentId, Integer current) {
        List<ReplyDTO> data = commentService.listRepliesByCommentId(commentId, current);
        return Result.ok().data("data", data);
    }

    @ApiOperation("分页获取用户评论列表")
    @GetMapping("/getUserCommentList")
    public Result getUserInfoList(Integer current, Integer size, String nickname) {
        List<CommentBackDTO> list = commentService.getUserReplyList(current, size, nickname);
        int total = commentService.count();
        return Result.ok().data("data", list).data("total", total);
    }
}
