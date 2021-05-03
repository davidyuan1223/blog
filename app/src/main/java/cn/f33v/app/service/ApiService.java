package cn.f33v.app.service;

import cn.f33v.app.dto.ApiBackDTO;
import cn.f33v.app.dto.PageDTO;
import cn.f33v.app.entity.Api;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Administrator
 */
public interface ApiService extends IService<Api> {
    boolean saveOrUpdateApiFromSwagger(List<Api> apiList);

    PageDTO<ApiBackDTO> listApiInfoBack(Integer current, Integer size, Integer apiId);

    List<Api> listByRoleId(Integer roleId);
}
