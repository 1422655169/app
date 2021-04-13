package com.zzx.servlet.rent;

import com.zzx.model.Rent;
import com.zzx.service.RentService;
import com.zzx.service.impl.RentServiceImpl;
import com.zzx.util.PageUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RentSelectAll extends HttpServlet {
    private RentService rentService = new RentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收前端传过来的关键字
        String rlname = req.getParameter("rlname");
        String raddress = req.getParameter("raddress");
        System.out.println("rlname的值"+rlname);
        System.out.println("raddress的值"+raddress);


        HashMap<String,String> map = new HashMap<>();
        map.put("rlname",rlname);
        map.put("raddress",raddress);
        System.out.println(map+"日志map::::::::::::::::");

        //接收参数,当前页
        String pageNoStr = req.getParameter("pageNo");
        System.out.println("日志:pageNoStr的值 "+ pageNoStr);
        int pageNo =  Integer.parseInt(pageNoStr);

        //总条数
        int total = rentService.count(map);
        PageUtil pageUtil = new PageUtil(pageNo,total);

        List<Rent> list = rentService.findAll(pageUtil,map);
        System.out.println("日志:Contract.doget"+list);

        req.setAttribute("list",list);
        req.setAttribute("pageUtil",pageUtil);
        req.setAttribute("keywordMap",map);

        //查询全部后进入页面
        req.getRequestDispatcher("/view/rent/show.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }









}
