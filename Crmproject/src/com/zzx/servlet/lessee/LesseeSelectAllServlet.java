package com.zzx.servlet.lessee;

import com.zzx.model.Contract;
import com.zzx.model.Lessee;
import com.zzx.service.LesseeService;
import com.zzx.service.impl.LesseeServiceImpl;
import com.zzx.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LesseeSelectAllServlet extends HttpServlet {

    private LesseeService lesseeService = new LesseeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //接收查询到的关键字
        String lname = req.getParameter("lname");
        System.out.println("郑子轩的日志show:lname " +lname);

        HashMap<String,String> keywordMap = new HashMap<>();
        keywordMap.put("Lname",lname);
        System.out.println("郑子轩的日志:Lname = "+keywordMap);

        //接收参数-当前页
        String pageStr = req.getParameter("pageNo");
        System.out.println("郑子轩的日志: 从前天接收到当前页的页码是 :" +pageStr);
        int pageNo = Integer.parseInt(pageStr);

        //调用业务层,查询共多少条记录
        int total = lesseeService.count(keywordMap);
        PageUtil pageUtil = new PageUtil(pageNo,total);



        //调用HouseService层处理
        ArrayList<Lessee> list = lesseeService.SelectAll(pageUtil,keywordMap);

        //存入Session域中
        req.getSession().setAttribute("list",list);
        req.getSession().setAttribute("pageUtil",pageUtil);
        req.setAttribute("keywordMap",keywordMap);

        //查询全部后进入页面
        req.getRequestDispatcher("/view/lesseee/show.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }



}
