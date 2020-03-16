package org.nood.auth.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.nood.auth.service.UserService;
import org.nood.auth.vo.UserVO;
import org.nood.code.utils.BeanUtil;
import org.nood.code.vo.Result;
import org.nood.auth.entity.SysUser;
import org.nood.auth.utils.JwtTokenUtil;
import org.springframework.beans.BeanUtils;
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
    public Result<UserVO> test(@RequestParam(name="token") String token) {
        log.info("token:{}",token);
        if (token != null && token.startsWith(tokenHead)) {
            String authToken = token.substring(tokenHead.length());
            String username = jwtTokenUtil.parseToken(authToken);
            log.info(" from get username:{}",username);
            try {
                SysUser user=userService.findByName(username);
                if(user==null){
                    return  Result.failed("用户不存在");
                }
                UserVO userVO= BeanUtil.convert(user,UserVO.class);
                return  Result.succeed(userVO);
            } catch (Exception e) {
                log.error("获取用户错误：{}",e);
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
