package com.zzx.servlet.user;
import com.zzx.service.UserService;
import com.zzx.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDeleteServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 接收参数
        String uids = req.getParameter("uid");
        int id = Integer.parseInt(uids);
        System.out.println("日志 ： UserDeleteServlet id = " +id);

        // 调用Service层处理
        UserService userService = new UserServiceImpl();
        userService.findDeleteById(id);
        System.out.println("------");

        // 处理完毕返回页面重新查询页面
        resp.sendRedirect(req.getContextPath()+"/user/user/selectall?pageNo=1");
    }
}
