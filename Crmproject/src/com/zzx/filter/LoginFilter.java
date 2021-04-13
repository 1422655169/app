package com.zzx.filter;

import com.zzx.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * 登录拦截
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //取出Session
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession( );
        User user = (User) session.getAttribute("user");
        String uri = req.getRequestURI();

        System.out.println("日志:LoginFilter-"+ uri);
        System.out.println("日志:LoginFilter - user"+ user);
        //判断是否有值
        if (user != null || uri.contains("/user/login")||uri.endsWith("index.jsp")){
            //有值就放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //没值,重新登陆
            HttpServletResponse resp = (HttpServletResponse) servletResponse;
            resp.sendRedirect(req.getContextPath()+"/index.jsp");

        }
    }

    @Override
    public void destroy() {}
}
