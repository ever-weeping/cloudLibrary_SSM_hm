package com.sea.controller;

import com.sea.domain.User;
import com.sea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
用户登录和注销 Controller
 */
@Controller
public class UserController {
    // 注入 UserService 对象
    @Autowired
    private UserService userService;

    // 用户登录
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request){
//        System.out.println("用户开始登录");
        try{
            User u = userService.login(user);
            /*
            账号和密码是否查询出用户信息
                是：将用户信息存入session中
                否：Request 域中添加提示信息，并转发到登录界面
             */
            if (u != null){
                request.getSession().setAttribute("USER_SESSION",u);
                return "redirect:/admin/main.jsp";
            }
            request.setAttribute("msg","用户名或密码错误");
            return "forward:/admin/login.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","系统错误");
            return "forward:/admin/login.jsp";
        }
    }

    // 退出登录
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            // 销毁session
            session.invalidate();
            return "forward:/admin/login.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","系统错误");
            return "forward:/admin/login.jsp";
        }
    }
}
