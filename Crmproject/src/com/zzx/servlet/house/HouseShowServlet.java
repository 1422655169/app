package com.zzx.servlet.house;

import com.zzx.model.House;
import com.zzx.service.HouseService;
import com.zzx.service.UserService;
import com.zzx.service.impl.HouseServiceImpl;
import com.zzx.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HouseShowServlet extends HttpServlet {
    private HouseService houseService = new HouseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //接收前台查询到的关键字
        String address = req.getParameter("address");
        System.out.println("郑子轩的日志show:address " +address);

        //将数据存入到HashMap集合中
        HashMap<String,String> keywordMap = new HashMap<>();
        keywordMap.put("address",address);
        System.out.println("keyword中获取到的数据"+keywordMap);
        // 接收参数,当前页
        String pageStr = req.getParameter("pageNo");
        System.out.println("接收到当前页的数据为"+pageStr);
        int pageNo = Integer.parseInt(pageStr);
        //调用业务层,查询共多少条记录
        int total = houseService.count(keywordMap);
        PageUtil pageUtil = new PageUtil(pageNo,total);
        List<House> list = houseService.findAll(pageUtil,keywordMap);
        System.out.println(list +"查询到的数据为");

        //将数据存入到session域中
        req.setAttribute("list",list);
        req.setAttribute("pageUtil",pageUtil);
        req.setAttribute("keywordMap",keywordMap);

        //查询全部后进入页面
        req.getRequestDispatcher("/view/house/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
