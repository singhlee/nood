package org.nood.auth.security;

import com.alibaba.fastjson.JSON;
import org.nood.code.vo.Result;
import org.nood.code.vo.ReturnCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: nood
 * @description: 用户未登录时返回给前端的数据
 * @author: singhlee
 * @create: 2020-03-11 20:21
 **/
@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(Result.failedWith(null, ReturnCode.USER_NEED_AUTHORITIES.getCode(),ReturnCode.USER_NEED_AUTHORITIES.getValue())));
    }

}
