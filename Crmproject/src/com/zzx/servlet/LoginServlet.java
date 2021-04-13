package com.zzx.servlet;

import com.zzx.model.Auth;
import com.zzx.model.User;
import com.zzx.service.UserService;
import com.zzx.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {

    //引入日志对象
    private Logger logger= Logger.getLogger(LoginServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 编码设置
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 接收数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //log4j输出级别
        logger.debug("username = "+username+",password = "+password);
        logger.info("username = "+username+",password = "+password);
        logger.warn("username = "+username+",password = "+password);
        logger.error("username = "+username+",password = "+password);

       // System.out.println("郑子轩的日志是:此时获取到前端的数据为username="+username+"--------password是:"+password+"*****");

        UserService service = new UserServiceImpl();
        User user = service.logins(username,password);
        System.out.println("郑子轩的日志:从数据库查到的数据为"+user);

        //2.查询用户的权限
        List<Auth> auths = service.findUserAuth(user);




        // 做响应
        if (user != null){      //次数如果获得到的数据不为空,那抹就说明username,password正确
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            session.setAttribute("auths",auths);
            //转发至查全部,让其查全部数据,并跳转至展示页面
            req.getRequestDispatcher("/view/mainpage/admin.jsp").forward(req,resp);
        }else {                 //表示登录失败
            req.setAttribute("msg","用户或者密码错误");
            //http://localhost:8080/Crmproject_war_exploded/
            //resp.sendRedirect("/Crmproject_war_exploded/");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}
