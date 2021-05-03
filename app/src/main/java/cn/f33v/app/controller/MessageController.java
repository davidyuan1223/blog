package cn.f33v.app.controller;

import cn.f33v.app.entity.Message;
import cn.f33v.app.service.impl.MessageServiceImpl;
import cn.f33v.app.vo.MessageVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.f33v.app.result.Result;

import java.util.List;

/**
 * @author Administrator
 */
@RestController
@Api("用户留言模块")
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;

    @ApiOperation("添加留言")
    @PostMapping("/messages")
    public Result saveMessage(@RequestBody MessageVO messageVO) {
        messageService.saveMessage(messageVO);
        return Result.ok().message("留言成功");
    }

    @ApiOperation("查看留言列表")
    @GetMapping("/getMessageList")
    public Result getMessageList(@RequestParam(value = "current", required = true, defaultValue = "1") Integer current,
                                 @RequestParam(value = "size", required = true, defaultValue = "5") Integer size,
                                 @RequestParam(value = "nickname", required = false) String nickname) {
        IPage<Message> page = messageService.getMessageList(current, size, nickname);
        long total = page.getTotal();
        List<Message> data = page.getRecords();
        return Result.ok().data("data", data).data("total", total);
    }
}
