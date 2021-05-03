package cn.f33v.app.service.impl;

import cn.f33v.app.dto.UserListPagDTO;
import cn.f33v.app.entity.Api;
import cn.f33v.app.exception.BusinessException;
import cn.f33v.app.vo.RegisterUserVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.f33v.app.dao.UserDao;
import cn.f33v.app.entity.User;
import cn.f33v.app.service.UserService;
import cn.f33v.app.common.DefaultUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-04-25 16:24:17
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public User getUserByUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return this.baseMapper.selectOne(wrapper);
    }

    @Override
    public List<String> listUserRolesByUsername(String username) {
        return this.baseMapper.listUserRolesByUsername(username);
    }

    @Override
    public boolean checkLogin(String username, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("password").eq("username", username);
        User user = this.baseMapper.selectOne(wrapper);
        if (user == null) {
            return false;
        }
        String userPassword = user.getPassword();
        return bCryptPasswordEncoder.matches(password, userPassword);
    }

    @Override
    public IPage<UserListPagDTO> getUserListPage(Page<UserListPagDTO> page, String roleName, String nickname) {
        return this.baseMapper.getUserListPage(page, roleName, nickname);
    }

    @Override
    public void sendCode(String email) {
        if (!checkEmail(email)) {
            throw new BusinessException("邮箱格式不正确");
        }
        int code = 666666;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("y1406957364@163.com");
        message.setTo(email);
        message.setSubject("验证码");
        message.setText("验证码为: " + Integer.toString(code) + "有效期15分钟");
        javaMailSender.send(message);
    }

    @Override
    public boolean registerUser(RegisterUserVO registerUserVO) {
        User user = new User();
        String code = registerUserVO.getCode();
        if (!code.equals("666666")) {
            throw new BusinessException("验证码错误");
        }
        //加密密码
        String encode = bCryptPasswordEncoder.encode(registerUserVO.getPassword());
        user.setPassword(encode);
        user.setAvatar(DefaultUser.DEFAULT_AVATAR);
        user.setNickname(DefaultUser.NICKNAME);
        user.setUsername(registerUserVO.getUsername());
        return this.save(user);
    }

    @Override
    public List<Api> getApiUrlByUsername(String username) {
        return this.baseMapper.getApiUrlByUsername(username);
    }

    @Override
    public boolean checkEmail(String username) {
        String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        //正则表达式的模式 编译正则表达式
        Pattern p = Pattern.compile(RULE_EMAIL);
        //正则表达式的匹配器
        Matcher m = p.matcher(username);
        //进行正则匹配
        return m.matches();
    }
}
