package org.nood.controller;

import lombok.extern.slf4j.Slf4j;
import org.nood.code.utils.AddressUtil;
import org.nood.code.vo.Result;
import org.nood.entity.SysRole;
import org.nood.entity.SysUser;
import org.nood.repository.SysUserDao;
import org.nood.service.JwtUserDetailService;
import org.nood.utils.JwtTokenUtil;
import org.nood.utils.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: nood
 * @description:
 * @author: singhlee
 * @create: 2020-03-11 16:47
 **/
@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @RequestMapping(value = "/test")
    public String test(@RequestBody SysUser user) {
        log.info("测试是否有权限");
        return "有权限";
    }
}
