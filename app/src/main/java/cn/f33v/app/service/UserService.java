package cn.f33v.app.service;

import cn.f33v.app.dto.UserListPagDTO;
import cn.f33v.app.entity.Api;
import cn.f33v.app.vo.RegisterUserVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.f33v.app.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-04-25 16:24:17
 */
public interface UserService extends IService<User> {
    User getUserByUsername(String username);

    List<String> listUserRolesByUsername(String username);

    boolean checkLogin(String username, String password);

    IPage<UserListPagDTO> getUserListPage(Page<UserListPagDTO> page, String roleName, String nickname);

    void sendCode(String email);

    boolean registerUser(RegisterUserVO registerUserVO);

    List<Api> getApiUrlByUsername(String username);

    boolean checkEmail(String username);
}
