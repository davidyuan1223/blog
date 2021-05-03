package cn.f33v.app.controller;

import cn.f33v.app.dto.MenuDTO;
import cn.f33v.app.service.impl.MenuServiceImpl;
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
@RestController
@Api("菜单展示模块")
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuServiceImpl menuService;

    @ApiOperation("获取展示菜单列表")
    @GetMapping("/getMenuList")
    public Result getMenuList() {
        List<MenuDTO> list = menuService.listProduct();
        if (menuService == null) {
            return Result.error().message("没有权限访问列表");
        } else {
            return Result.ok().data("menuList", list);
        }
    }
}
