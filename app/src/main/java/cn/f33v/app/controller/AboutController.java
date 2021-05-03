package cn.f33v.app.controller;

import cn.f33v.app.dao.AboutDao;
import cn.f33v.app.dto.AboutDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.f33v.app.result.Result;

/**
 * @author Administrator
 */
@RestController
@Api(tags = "关于模块")
public class AboutController {

    @Autowired
    private AboutDao aboutDao;

    @ApiOperation("/获取关于我的信息")
    @GetMapping("/getAbout")
    public Result getAbout() {
        AboutDTO aboutDTO = aboutDao.getAbout();
        return Result.ok().data("data", aboutDTO);
    }

    @ApiOperation("更新关于我")
    @PutMapping("/updateAbout")
    public Result updateAbout(String aboutContent) {
        int i = aboutDao.updateAbout(aboutContent);
        return Result.ok();
    }
}
