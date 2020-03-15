package org.nood.security;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.nood.code.utils.AddressUtil;
import org.nood.code.vo.Result;
import org.nood.code.vo.ReturnCode;
import org.nood.utils.JwtTokenUtil;
import org.nood.utils.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: nood
 * @description: 用户登录成功时返回给前端的数据
 * @author: singhlee
 * @create: 2020-03-12 14:21
 **/
@Component
@Slf4j
public class UserAuthenticationSuccessHandler  implements AuthenticationSuccessHandler {

    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //获取请求的ip地址
        String ip = AddressUtil.getIpAddress(httpServletRequest);
        Map<String,Object> map = new HashMap<>();
        map.put("ip",ip);
        JwtUserDetails userDetails = (JwtUserDetails) authentication.getPrincipal();
        String jwtToken = jwtTokenUtil.generateToken(userDetails.getUsername(),map);
        //刷新时间
        jwtTokenUtil.setTokenRefresh(jwtToken,userDetails.getUsername(),ip);
        log.info("用户{}登录成功，信息已保存至redis",userDetails.getUsername());
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(Result.succeed(jwtToken,"登录成功")));
    }

    @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

}
