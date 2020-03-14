package org.nood.security;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.nood.code.vo.Result;
import org.nood.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: nood
 * @description: 退出成功
 * @author: singhlee
 * @create: 2020-03-12 14:30
 **/
@Slf4j
@Component
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String authHeader = httpServletRequest.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            final String authToken = authHeader.substring("Bearer ".length());
            //将token放入黑名单中
            jwtTokenUtil.addBlackList(authToken);
            log.info("用户登出成功！token：{}已加入redis黑名单",authToken);
        }
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(Result.succeed("退出成功")));
    }
}
