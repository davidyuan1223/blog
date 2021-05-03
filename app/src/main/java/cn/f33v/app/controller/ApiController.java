package cn.f33v.app.controller;

import cn.f33v.app.dto.ApiBackDTO;
import cn.f33v.app.dto.PageDTO;
import cn.f33v.app.result.Result;
import cn.f33v.app.service.ApiService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author Administrator
 */
@Slf4j
@RestController
@Api("api模块")
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private ApiService apiService;

    @ApiOperation("根据swagger2的api文档读取api信息存入数据库")
    @PostMapping("/saveOrUpdateApiFromSwagger")
    public Result saveOrUpdateApiFromSwagger(@RequestBody List<cn.f33v.app.entity.Api> api) {
        log.info(api.toString());
        if (apiService.saveOrUpdateApiFromSwagger(api)) {
            return Result.ok();
        }
        return Result.error();
    }

    @ApiOperation(value = "分类条件查询查询api信息,父pid查询模块所有api")
    @GetMapping("/listApiInfoBack")
    public Result listApiInfoBack(@RequestParam(value = "current", required = true, defaultValue = "1") Integer current,
                                  @RequestParam(value = "size", required = true, defaultValue = "10") Integer size,
                                  @RequestParam(value = "apiId", required = true, defaultValue = "1") Integer apiId) {
        PageDTO<ApiBackDTO> backDTOPage = apiService.listApiInfoBack(current, size, apiId);
        return Result.ok().data("data", backDTOPage);
    }

}
