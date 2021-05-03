package cn.f33v.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.f33v.app.dao.UserLoginDao;
import cn.f33v.app.entity.UserLogin;
import cn.f33v.app.service.UserLoginService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * (UserLogin)表服务实现类
 *
 * @author makejava
 * @since 2021-04-25 16:24:24
 */
@Service("userLoginService")
public class UserLoginServiceImpl extends ServiceImpl<UserLoginDao, UserLogin> implements UserLoginService {

    @Override
    public IPage<UserLogin> getUserInfoList(Integer current, Integer size, String nickname) {
        Page<UserLogin> page = new Page<>(current, size);
        QueryWrapper<UserLogin> wrapper = null;
        if (nickname != null && !Objects.equals(nickname, "")) {
            wrapper = new QueryWrapper<>();
            wrapper.like("nickname", nickname);
        }
        return this.baseMapper.selectPage(page, wrapper);
    }
}
