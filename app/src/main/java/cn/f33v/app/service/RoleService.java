package cn.f33v.app.service;

import cn.f33v.app.vo.RoleApiVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.f33v.app.entity.Role;

import java.util.List;

/**
 * (Role)表服务接口
 *
 * @author makejava
 * @since 2021-04-25 16:23:58
 */
public interface RoleService extends IService<Role> {
    List<Integer> getAssignedApiIdByUserRoleId(Integer roleId);

    Integer saveRolePermissionList(Integer roleId, List<RoleApiVO> roleApiVOList);
}
