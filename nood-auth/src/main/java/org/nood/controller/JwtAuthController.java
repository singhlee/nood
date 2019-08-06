package org.nood.controller;

import org.nood.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ProjectName: nood
 * @Package: org.nood.controller
 * @ClassName: JwtAuthController
 * @Author: LX
 * @Description:
 * @Date: 2019/7/29 16:06
 * @Version: 1.0
 */
public class JwtAuthController {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     * @throws AuthenticationException
     */
    @RequestMapping(value = "/authentication/login", method = RequestMethod.POST)
    public String createToken( String username,String password ) throws AuthenticationException {
        return null;
    }

    /**
     * 注册
     * @param addedUser
     * @return
     * @throws AuthenticationException
     */
    @RequestMapping(value = "/authentication/register", method = RequestMethod.POST)
    public SysUser register(@RequestBody SysUser addedUser ) throws AuthenticationException {
        return null;
    }

}
