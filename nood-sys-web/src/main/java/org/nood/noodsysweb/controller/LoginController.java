package org.nood.noodsysweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);


    @RequestMapping("/")
    public String index() {
         System.out.println("login");
         return "login";
    }

    @RequestMapping("login")
    public String login() {
        System.out.println("login");
        return "main";
    }


    @RequestMapping("register")
    public String register() {

        return "register";
    }


}
