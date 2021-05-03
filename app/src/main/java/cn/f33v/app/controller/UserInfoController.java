package cn.f33v.app.controller;

import cn.f33v.app.dto.BlogHomeInfoDTO;
import cn.f33v.app.service.BlogInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.f33v.app.result.Result;

/**
 * @author Administrator
 */
@Api("博客信息模块")
@RestController
@RequestMapping("/blogInfo")
public class UserInfoController {
    @Autowired
    private BlogInfoService blogInfoService;

    @ApiOperation("获取博客基本信息")
    @GetMapping("/getBlogInfo")
    public Result getBlogInfo() {
        BlogHomeInfoDTO blogHome = blogInfoService.getBlogHomeInfo();
        return Result.ok().data("data", blogHome);
    }
}
