package cn.f33v.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.f33v.app.entity.UserLogin;

/**
 * (UserLogin)表服务接口
 *
 * @author makejava
 * @since 2021-04-25 16:24:24
 */
public interface UserLoginService extends IService<UserLogin> {
    IPage<UserLogin> getUserInfoList(Integer current, Integer size, String nickname);
}
