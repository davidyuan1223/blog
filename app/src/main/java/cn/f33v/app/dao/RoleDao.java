package cn.f33v.app.dao;

import cn.f33v.app.vo.RoleApiVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.f33v.app.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Role)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-24 22:19:44
 */


@Mapper
@Repository
public interface RoleDao extends BaseMapper<Role> {
    List<Integer> getAssignedApiIdByUserRoleId(@Param("roleId") Integer roleId);

    Integer saveRolePermissionList(@Param("roleId") Integer roleId, @Param("list") List<RoleApiVO> roleApiVOList);

    Integer deleteRolePermissionList(@Param("roleId") Integer roleId);
}
