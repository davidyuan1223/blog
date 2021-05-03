package cn.f33v.app.controller;

import cn.f33v.app.dto.UserListPagDTO;
import cn.f33v.app.entity.User;
import cn.f33v.app.service.impl.UserServiceImpl;
import cn.f33v.app.vo.RegisterUserVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.f33v.app.result.Result;

import java.util.List;
import java.util.Objects;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/user")
@Api("用户模块")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation("根据用户角色和昵称分页查询用户列表")
    @GetMapping("/getUserList")
    public Result getUserList(@RequestParam(value = "current", required = true, defaultValue = "1") Integer current,
                              @RequestParam(value = "size", required = true, defaultValue = "5") Integer size,
                              @RequestParam(value = "roleName", required = false) String roleName,
                              @RequestParam(value = "nickname", required = false) String nickname) {
        Page<UserListPagDTO> page = new Page<>(current, size);
        IPage<UserListPagDTO> user = userService.getUserListPage(page, roleName, nickname);
        long total = user.getTotal();
        List<UserListPagDTO> data = user.getRecords();
        return Result.ok().data("data", data).data("total", total);
    }

    @ApiOperation("发送邮箱验证码")
    @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "String")
    @GetMapping("/sendEmailCode")
    public Result sendCode(String email) {
        userService.sendCode(email);
        return Result.ok().message("验证码发送成功,请注意查收");
    }

    @ApiOperation("注册")
    @PostMapping("/registerUser")
    public Result registerUser(@RequestBody RegisterUserVO registerUserVO) {
        if (userService.registerUser(registerUserVO)) {
            return Result.ok().message("注册成功");
        }
        return Result.error().message("注册失败");
    }

    @ApiOperation("分页单表查询用户列表")
    @GetMapping("/getUserListSignal")
    public Result getUserListSignal(Integer current, Integer size, String nickname) {
        QueryWrapper<User> queryWrapper = null;
        if (nickname != null && !Objects.equals(nickname, "")) {
            queryWrapper = new QueryWrapper<>();
            queryWrapper.like("nickname", nickname);
        }
        IPage<User> page = userService.page(new Page<User>(current, size), queryWrapper);
        long total = page.getTotal();
        List<User> data = page.getRecords();
        return Result.ok().data("data", data).data("total", total);
    }
}
