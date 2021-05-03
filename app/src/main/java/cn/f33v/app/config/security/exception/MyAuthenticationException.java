package cn.f33v.app.config.security.exception;

import javax.naming.AuthenticationException;

/**
 * @author Administrator
 */
public class MyAuthenticationException extends AuthenticationException {
    public MyAuthenticationException(String explanation) {
        super(explanation);
    }
}
