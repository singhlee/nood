package org.nood.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.nood.auth.entity.SysUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
