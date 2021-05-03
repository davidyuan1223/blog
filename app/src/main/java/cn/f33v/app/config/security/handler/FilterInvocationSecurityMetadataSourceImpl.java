package cn.f33v.app.config.security.handler;

import cn.f33v.app.dao.ApiDao;
import cn.f33v.app.dao.RoleDao;
import cn.f33v.app.dao.UserDao;
import cn.f33v.app.entity.Api;
import cn.f33v.app.entity.Menu;
import cn.f33v.app.entity.Role;
import cn.f33v.app.service.ApiService;
import cn.f33v.app.service.impl.MenuServiceImpl;
import cn.f33v.app.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * @author Administrator
 */
@Component
public class FilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource {


    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Autowired
    private ApiService apiService;
    @Autowired
    private RoleServiceImpl roleService;


    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) o;
        String url = fi.getRequest().getRequestURI();
        String method = fi.getRequest().getMethod();
        if (method.equals("GET")) {
            return SecurityConfig.createList("ROLE_LOGIN");
        }
        List<Api> apis = apiService.list();
        for (Api api : apis) {
            if (api.getUrl() != null) {
                if (antPathMatcher.match(api.getUrl(), url)) {
                    List<Role> roles = roleService.list();
                    String[] str = new String[roles.size()];
                    for (int i = 0; i < roles.size(); i++) {
                        str[i] = roles.get(i).getRoleName();
                    }
                    return SecurityConfig.createList(str);
                }
            }

        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
