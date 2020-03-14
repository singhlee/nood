package org.nood.security;

import com.alibaba.fastjson.JSON;
import org.nood.code.vo.Result;
import org.nood.code.vo.ReturnCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: nood
 * @description: 用户登录失败时返回给前端的数据
 * @author: singhlee
 * @create: 2020-03-12 14:22
 **/
@Component
public class UserAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(Result.failedWith(null, ReturnCode.USER_LOGIN_FAILED.getCode(),ReturnCode.USER_LOGIN_FAILED.getValue())));
    }
}
