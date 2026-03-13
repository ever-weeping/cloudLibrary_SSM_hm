package com.sea.interceptor;

import com.sea.domain.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ResourcesInterceptor extends HandlerInterceptorAdapter {
    // 任意角色都能访问的路径
    private List<String> ignoreUrl;
    public ResourcesInterceptor(List<String> ignoreUrl){
        this.ignoreUrl = ignoreUrl;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("USER_SESSION");
        String uri = request.getRequestURI();

        if (uri.contains("login")){
            return true;
        }

        // 如果用户是已登录的状态，判断访问的资源是否有权限
        if (user != null){
            if ("ADMIN".equals(user.getRole())){
                return true;
            }else {
                for (String url : ignoreUrl){
                    if (uri.contains(url)){
                        return true;
                    }
                }
            }
        }
        // 其他情况都直接跳转到登录界面
        request.setAttribute("msg","您还没登录，请先登录！");
        request.getRequestDispatcher("/admin/login.jsp").forward(request,response);
        return false;
    }
}
