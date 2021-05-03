package cn.f33v.app.controller;

import cn.f33v.app.entity.FriendLink;
import cn.f33v.app.service.impl.FriendLinkServiceImpl;
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
@Api("友链模块")
@RequestMapping("/friend")
public class FriendLinkController {

    @Autowired
    private FriendLinkServiceImpl friendLinkService;

    @ApiOperation("添加或修改友链")
    @PostMapping("/addOrEditFriendLink")
    public Result addOrEditFriendLink(@RequestBody FriendLink friendLink) {
        if (friendLinkService.addOrEditFriendLink(friendLink)) {
            return Result.ok();
        }
        return Result.error();
    }

    @ApiOperation("根据关键词分页查询友链")
    @GetMapping("/listLinks")
    public Result listLinks(@RequestParam(value = "current", required = true, defaultValue = "1") Integer current,
                            @RequestParam(value = "size", required = true, defaultValue = "5") Integer size,
                            @RequestParam(value = "keywords", required = false) String keywords) {
        IPage<FriendLink> page = friendLinkService.pageLinks(current, size, keywords);
        long total = page.getTotal();
        List<FriendLink> records = page.getRecords();
        return Result.ok().data("data", records).data("total", total);
    }
}
