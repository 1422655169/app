package com.zzx.servlet.user;

import com.zzx.model.Role;
import com.zzx.model.User;
import com.zzx.service.UserService;
import com.zzx.service.impl.UserServiceImpl;
import com.zzx.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserShowServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //接收查询到的关键字
        String uname = req.getParameter("uname");
        String rname = req.getParameter("rname");
        System.out.println("郑子轩的日志show:uname的值为 " +uname+"; rname的值为: "+rname);

        HashMap<String, String> keywordMap = new HashMap<>( );
        keywordMap.put("Uname",uname);
        keywordMap.put("rname",rname);
        System.out.println("日志:UserListServlet.doGet keywordMap = "+keywordMap );

        //接收参数 -当前页
        String pageStr = req.getParameter("pageNo");
        System.out.println("日志:UserListServlet.doGet pageStr = "+pageStr);
        int pageNo =Integer.parseInt(pageStr);

        //总条数
        int total = userService.count(keywordMap);
        PageUtil pageUtil = new PageUtil(pageNo,total);

        List<User> users = userService.findAll(pageUtil,keywordMap);
        //调用HouseService层处理
        List<User> list  = userService.findRole(users);


        req.setAttribute("list", list);
        req.setAttribute("pageUtil", pageUtil);
        req.setAttribute("keywordMap", keywordMap);

        //查询全部后进入页面
        req.getRequestDispatcher("/view/user/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }



}
