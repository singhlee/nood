package org.nood.controller;

import lombok.extern.slf4j.Slf4j;
import org.nood.code.vo.Result;
import org.nood.entity.SysUser;
import org.nood.service.UserService;
import org.nood.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: nood
 * @description:
 * @author: singhlee
 * @create: 2020-03-15 17:23
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    private JwtTokenUtil jwtTokenUtil;
    private UserService userService;
    private String tokenHead = "Bearer ";

    @GetMapping(value = "/info")
    public Result test(@RequestParam(name="token") String token) {
        log.info("token:{}",token);
        if (token != null && token.startsWith(tokenHead)) {
            String authToken = token.substring(tokenHead.length());
            String username = jwtTokenUtil.parseToken(authToken);
            log.info(" from get username:{}",username);
            try {
                SysUser user=userService.findByName(username);
                return  Result.succeed(user);
            } catch (Exception e) {
                return  Result.failed("系统错误");
            }
        }
        return  Result.failed("token为空");
    }

   @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
