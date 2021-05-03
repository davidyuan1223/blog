package cn.f33v.app.config.security;

import cn.f33v.app.config.security.exception.MyAuthenticationException;
import cn.f33v.app.entity.Api;
import cn.f33v.app.service.ApiService;
import cn.f33v.app.service.UserService;
import com.alibaba.fastjson.JSON;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

/**
 * @author Administrator
 */
@Component
public class DynamicPermission {
    private final static String PERMISSION_KEY = "PERMISSION_KEY";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    HttpServletRequest request;
    @Autowired
    private UserService userService;
    @Autowired
    private ApiService apiService;

    @NonNull
    public boolean checkPermission(Authentication authentication) throws MyAuthenticationException {
        String name = authentication.getName();
        if (name.equals("anonymousUser")) {
            String method = request.getMethod();
            if (method.equals("GET")) {
                return true;
            } else {
                throw new MyAuthenticationException("非法操作!");
            }
        }
        //获取当前用户认证信息
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            //获取到用户登录时输入表单的用户名
            String username = userDetails.getUsername();
            //通过账号获取资源鉴权查看当前用户下的权限信息表
            //这个鉴权查询常用,加入缓存
            List<Api> apiUrls = apiService.listByRoleId(1);
            //AntPathMatcher antPathMatcher=new AntPathMatcher()
            //当前访问路径
            String requestURI = request.getRequestURI();
            //提交类型
            //判断当前路径在不在访问资源中
            boolean hashAntPath = false;
            AntPathMatcher pathMatcher = new AntPathMatcher();
            //判断当前访问路径在不在权限表里面
            for (Api apiUrl : apiUrls) {
                if (apiUrl.getUrl() != null) {
                    if (pathMatcher.match(apiUrl.getUrl(), requestURI)) {
                        hashAntPath = true;
                        break;
                    }
                }
            }
            if (hashAntPath) {
                return true;
            } else {
                throw new MyAuthenticationException("用户权限不足");
            }
        } else {
            throw new MyAuthenticationException("不是UserDetails类型");
        }
    }

    private List<Api> getApiUrlByUsername(String username) {
        List<Api> urls = null;
        String key = PERMISSION_KEY + "_" + username;
        String api = (String) redisTemplate.opsForValue().get(key);
        if (api != null && !Objects.equals(api, "")) {
            urls = JSON.parseArray(api, Api.class);
            return urls;
        }
        List<Api> apis = userService.getApiUrlByUsername(username);
        redisTemplate.opsForValue().set(key, JSON.toJSONString(apis), Duration.ofSeconds(1800L));
        return apis;
    }

}
