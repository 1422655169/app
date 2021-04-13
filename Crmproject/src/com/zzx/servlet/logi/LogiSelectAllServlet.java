package com.zzx.servlet.logi;

import com.zzx.model.Lessee;
import com.zzx.model.Logi;
import com.zzx.service.LesseeService;
import com.zzx.service.LogiService;
import com.zzx.service.impl.LogiServiceImpl;
import com.zzx.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LogiSelectAllServlet extends HttpServlet {
    private LogiService logiService = new LogiServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收前端传过来的关键字
        String loname = req.getParameter("loname");
        System.out.println("loname的值"+loname);


        HashMap<String,String> map = new HashMap<>();
        map.put("loname",loname);
        System.out.println(map+"日志map::::::::::::::::");

        //接收参数,当前页
        String pageNoStr = req.getParameter("pageNo");
        System.out.println("日志:pageNoStr的值 "+ pageNoStr);
        int pageNo =  Integer.parseInt(pageNoStr);

        //总条数
        int total = logiService.count(map);
        PageUtil pageUtil = new PageUtil(pageNo,total);

        List<Logi> list = logiService.findAll(pageUtil,map);
        System.out.println("日志:Contract.doget"+list);

        req.setAttribute("list",list);
        System.out.println("listAll++++++++************"+list);
        req.setAttribute("pageUtil",pageUtil);
        req.setAttribute("keywordMap",map);

        //查询全部后进入页面
        req.getRequestDispatcher("/view/logi/show.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }



}
