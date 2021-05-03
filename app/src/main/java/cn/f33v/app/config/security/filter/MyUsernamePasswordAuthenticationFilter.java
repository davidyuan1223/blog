package cn.f33v.app.config.security.filter;

import cn.f33v.app.config.security.exception.MyAuthenticationException;
import cn.f33v.app.config.security.login.UserAuth;
import cn.f33v.app.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author Administrator
 */
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter implements Filter {
    @Autowired
    private UserService userService;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (request.getContentType().contains(MediaType.APPLICATION_JSON_VALUE)) {
            ObjectMapper objectMapper = new ObjectMapper();
            UsernamePasswordAuthenticationToken authRequest = null;
            Map<String, String> authenticationBean = null;
            try (InputStream is = request.getInputStream()) {
                authenticationBean = objectMapper.readValue(request.getInputStream(), Map.class);
            } catch (IOException e) {
                try {
                    throw new MyAuthenticationException(e.getMessage());
                } catch (MyAuthenticationException ex) {
                    ex.printStackTrace();
                }
            }
            try {
                assert authenticationBean != null;
                if (!authenticationBean.isEmpty()) {
                    String username = authenticationBean.get(SPRING_SECURITY_FORM_USERNAME_KEY);
                    String password = authenticationBean.get(SPRING_SECURITY_FORM_PASSWORD_KEY);
                    if (userService.checkLogin(username, password)) {
                        authRequest = new UsernamePasswordAuthenticationToken(username, password);
                        setDetails(request, authRequest);
                        return this.getAuthenticationManager().authenticate(authRequest);
                    }
                }
            } catch (AuthenticationException e) {
                try {
                    throw new MyAuthenticationException(e.getMessage());
                } catch (MyAuthenticationException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return this.attemptAuthentication(request, response);
    }
}
