package com.zzx.servlet.user;

import com.zzx.model.User;
import com.zzx.service.UserService;
import com.zzx.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式,防止接收到的数据乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //接收数据
        String uname = req.getParameter("username");
        String upassword = req.getParameter("password");
        String urealname = req.getParameter("urealname");
        String uaddTimes = req.getParameter("uaddTime");
        String ustats = req.getParameter("ustatus");
        int ustatus = Integer.parseInt(ustats);

        //封装数据
        User user = new User();
        user.setUname(uname);
        user.setUpassword(upassword);
        user.setUrealname(urealname);
        user.setUstatus(ustatus);
        Date uaddTImes = null;
        try {
            uaddTImes = new SimpleDateFormat("yyyy-MM-dd").parse(uaddTimes);
        }catch (Exception e){
            e.printStackTrace();
        }
        user.setUaddTime(uaddTImes);

        System.out.println("郑子轩的注册日志:获取username : "+user + "Servlet从前端获取到了数据");

        //调用Service层处理
        UserService userService = new UserServiceImpl();
        userService.SignIn(user);

        //返回登录页面
        //req.getRequestDispatcher("/index.jsp").forward(req,resp);
        resp.sendRedirect("/Crmproject_war_exploded/index.jsp");
    }
}
