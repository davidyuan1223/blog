package cn.f33v.app.config.security.handler;

import cn.f33v.app.config.security.login.UserAuth;
import cn.f33v.app.entity.User;
import cn.f33v.app.entity.UserLogin;
import cn.f33v.app.service.UserLoginService;
import cn.f33v.app.utils.IpUtil;
import com.alibaba.fastjson.JSON;
import cn.f33v.app.common.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import cn.f33v.app.result.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author Administrator
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserLoginService loginService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        UserAuth userAuth = (UserAuth) authentication.getPrincipal();
        httpServletResponse.setContentType("application.json;cahrset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(Result.ok()
                .code(ResultInfo.VERIFY_SUCCESS.getCode())
                .message(ResultInfo.VERIFY_SUCCESS.getMessage())
                .data("user", userAuth)));
        String ipAddress = IpUtil.getIp(httpServletRequest);
        String ipSource = IpUtil.getIpSource(ipAddress);
        User loginUser = userAuth.getUser();
        UserLogin login = new UserLogin();
        login.setAvatar(loginUser.getAvatar());
        login.setIpAddress(ipAddress);
        login.setIpSource(ipSource);
        login.setNickName(loginUser.getNickname());
        login.setLastLoginTime(new Date());
        loginService.save(login);
    }
}
