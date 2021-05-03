package cn.f33v.app.dao;

import cn.f33v.app.dto.UserListPagDTO;
import cn.f33v.app.entity.Api;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.f33v.app.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-24 22:25:13
 */
@Mapper
@Repository
public interface UserDao extends BaseMapper<User> {
    List<String> listUserRolesByUsername(@Param("username") String username);

    IPage<UserListPagDTO> getUserListPage(@Param("page") Page<UserListPagDTO> page, @Param("roleName") String roleName, @Param("nickname") String nickname);

    List<Api> getApiUrlByUsername(@Param("username") String username);
}
