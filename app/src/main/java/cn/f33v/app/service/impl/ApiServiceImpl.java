package cn.f33v.app.service.impl;

/**
 * @author Administrator
 */

import cn.f33v.app.dao.ApiDao;
import cn.f33v.app.dto.ApiBackDTO;
import cn.f33v.app.dto.PageDTO;
import cn.f33v.app.entity.Api;
import cn.f33v.app.service.ApiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ApiServiceImpl extends ServiceImpl<ApiDao, Api> implements ApiService {
    @Override
    public boolean saveOrUpdateApiFromSwagger(List<Api> apiList) {
        return this.saveOrUpdateBatch(apiList);
    }

    @Override
    public PageDTO<ApiBackDTO> listApiInfoBack(Integer current, Integer size, Integer apiId) {
        //分页查出所有满足条件的api信息
        List<ApiBackDTO> apis = this.baseMapper.listApiInfoBack((current - 1) * size, size, apiId);
        //创建一个集合返回对象
        //计数
        int count = this.count();
        return new PageDTO<>(apis, count);
    }

    @Override
    public List<Api> listByRoleId(Integer roleId) {
        return this.baseMapper.listApiByRoleId(roleId);
    }
}
