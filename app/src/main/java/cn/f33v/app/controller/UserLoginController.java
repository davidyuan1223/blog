package cn.f33v.app.controller;

import cn.f33v.app.entity.UserLogin;
import cn.f33v.app.service.impl.UserLoginServiceImpl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.f33v.app.result.Result;

import java.util.List;

/**
 * @author Administrator
 */
@Api("用户登录模块")
@RestController
@RequestMapping("/userLogin")
public class UserLoginController {

    @Autowired
    private UserLoginServiceImpl userLoginService;

    @ApiOperation("分页获取用户登录信息列表")
    @GetMapping("/getUserInfoList")
    public Result getUserInfoList(Integer current, Integer size, String nickname) {
        IPage<UserLogin> page = userLoginService.getUserInfoList(current, size, nickname);
        long total = page.getTotal();
        List<UserLogin> data = page.getRecords();
        return Result.ok().data("data", data).data("total", total);
    }
}
