package com.user.client.ljn.controller;

import com.user.common.usercommon.entity.SysUserInfo;
import com.user.server.ljn.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String toLoginPage(){
        return "/login";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "username",required = false) String username,
                              @RequestParam(value = "password",required = false) String password, HttpSession httpSession, HttpServletRequest req){
        log.info("username,password:{},{}",username,password);
        SysUserInfo sysUserInfo =  userService.login(username,password);
        if(sysUserInfo != null) {
            req.getSession().setAttribute("sysUserInfo", sysUserInfo);
            req.getSession().setAttribute("id", sysUserInfo.getId());
        }else{
            return "redirect:login";

        }
        return "/admin/index";

    }
}
