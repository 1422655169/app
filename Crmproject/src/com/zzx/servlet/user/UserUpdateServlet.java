package com.zzx.servlet.user;


import com.zzx.model.User;
import com.zzx.service.UserService;
import com.zzx.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserUpdateServlet  extends HttpServlet {

       private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收数据
        String uids = req.getParameter("uid");
        int uid = Integer.parseInt(uids);

        // 调用Service层处理查询个人信息
        User user = userService.findUpdateById(uid);

        // 将数据存入session域中
        req.getSession().setAttribute("user",user);

         //查询完毕后将数据回显的该页面
        req.getRequestDispatcher("/view/user/update.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收数据进行更新
        String uids = req.getParameter("uid");
        int uid = Integer.parseInt(uids);

        String uname = req.getParameter("uname");
        String upassword = req.getParameter("upassword");
        String urealname = req.getParameter("urealname");

        String uaddTimes = req.getParameter("uaddTime");
        String ustatuss = req.getParameter("ustatus");
        int ustatus = Integer.parseInt(ustatuss);

        System.out.println("???"+ustatus);

        // 将数据进行封装
        User user = new User();
        user.setUid(uid);
        user.setUname(uname);
        user.setUpassword(upassword);
        user.setUrealname(urealname);
        Date uaddTime = null;
        try {
            uaddTime = new SimpleDateFormat("yyyy-MM-dd").parse(uaddTimes);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setUaddTime(uaddTime);
        user.setUstatus(ustatus);

        System.out.println("????"+user);

        // 调用Service层进行处理
        userService.findUpdateByAll(user);

        // 更新完数据返回页面进行查询全部
        resp.sendRedirect(req.getContextPath()+"/user/user/selectall?pageNo=1");
    }
}
