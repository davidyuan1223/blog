package cn.f33v.app.dao;

import cn.f33v.app.dto.ApiBackDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.f33v.app.entity.Api;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Api)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-24 17:18:13
 */
@Mapper
@Repository
public interface ApiDao extends BaseMapper<Api> {
    /**
     * 分页查询所有api返回信息
     *
     * @param current 当前
     * @param size    大小
     * @param apiId   apiId
     * @return ApiBackDTOList
     */
    List<ApiBackDTO> listApiInfoBack(@Param("current") Integer current, @Param("size") Integer size, @Param("apiId") Integer apiId);

    List<Api> listApiByRoleId(@Param("roleId") Integer roleId);
}
