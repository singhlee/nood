package org.nood.auth.security;

import com.alibaba.fastjson.JSON;
import org.nood.code.vo.Result;
import org.nood.code.vo.ReturnCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: nood
 * @description:
 * @author: singhlee
 * @create: 2020-03-11 20:56
 **/
@Component
public class UserAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(Result.failedWith(null, ReturnCode.USER_NO_ACCESS.getCode(),ReturnCode.USER_NO_ACCESS.getValue())));
    }
}
