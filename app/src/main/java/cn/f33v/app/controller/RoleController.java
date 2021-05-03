package cn.f33v.app.controller;

import cn.f33v.app.entity.Role;
import cn.f33v.app.service.impl.RoleServiceImpl;
import cn.f33v.app.vo.RoleApiVO;
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
@Api("角色模块")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @ApiOperation("获取角色列表")
    @GetMapping("/getRoleList")
    public Result getRoleList() {
        List<Role> list = roleService.list();
        return Result.ok().data("data", list);
    }

    @ApiOperation("根据角色id查询对应用于的ApiId列表")
    @GetMapping("/getAssignedApiIdByUserRoleId")
    public Result getAssignedApiIdByUserRoleId(@RequestParam(value = "actionId") Integer actionId) {
        List<Integer> data = roleService.getAssignedApiIdByUserRoleId(actionId);
        return Result.ok().data("data", data);
    }

    @ApiOperation("根据当前角色id分配api权限列表")
    @PostMapping("/saveRolePermissionList")
    public Result saveRolePermissionList(@RequestParam(value = "roleId") Integer roleId,
                                         @RequestBody List<RoleApiVO> roleApiVOList) {
        System.out.println(roleApiVOList);
        roleService.saveRolePermissionList(roleId, roleApiVOList);
        return Result.ok();
    }
}
