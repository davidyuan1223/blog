package cn.f33v.app.utils;

import cn.f33v.app.config.security.login.UserAuth;
import cn.f33v.app.entity.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Administrator
 */
public class UserUtil {
    public static User getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            UserAuth userAuth = (UserAuth) authentication.getPrincipal();
            return userAuth.getUser();
        }
        return null;
    }
}
