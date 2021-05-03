package cn.f33v.app.config.security.login;

import cn.f33v.app.entity.User;
import cn.f33v.app.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.isEmpty()) {
            throw new UsernameNotFoundException("用户名为空");
        }
        User user = userService.getUserByUsername(username);
        if (user != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            List<String> roles = userService.listUserRolesByUsername(username);
            SimpleGrantedAuthority simpleGrantedAuthority = null;
            for (String role : roles) {
                simpleGrantedAuthority = new SimpleGrantedAuthority(role);
                authorities.add(simpleGrantedAuthority);
            }
            UserAuth userAuth = new UserAuth();
            userAuth.setUser(user);
            userAuth.setAuthorities(authorities);
            return userAuth;
        } else {
            throw new UsernameNotFoundException("用户名不存在");
        }
    }
}
