package cn.f33v.app.service.impl;

import cn.f33v.app.vo.RoleApiVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.f33v.app.dao.RoleDao;
import cn.f33v.app.entity.Role;
import cn.f33v.app.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (Role)表服务实现类
 *
 * @author makejava
 * @since 2021-04-25 16:23:58
 */
@Service("roleService")
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {


    @Override
    public List<Integer> getAssignedApiIdByUserRoleId(Integer roleId) {
        return this.baseMapper.getAssignedApiIdByUserRoleId(roleId);
    }

    @Override
    public Integer saveRolePermissionList(Integer roleId, List<RoleApiVO> roleApiVOList) {
        if (roleId == null) {
            return 0;
        }
        Integer integer = 0;
        this.baseMapper.deleteRolePermissionList(roleId);
        if (roleApiVOList != null) {
            integer = this.baseMapper.saveRolePermissionList(roleId, roleApiVOList);
            return integer;
        }
        return integer;
    }
}
