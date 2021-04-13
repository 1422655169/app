package com.zzx.servlet.activity;

import com.zzx.model.Activity;

import com.zzx.service.ActivityService;
import com.zzx.service.impl.ActivityServiceImpl;
import com.zzx.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivityListServlet extends HttpServlet {

private ActivityService activityService = new ActivityServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收前端传过来的关键字
        String subject = req.getParameter("subject");
        String lowp = req.getParameter("lowprice");
        String highp = req.getParameter("highprice");
        System.out.println("lowp的值"+lowp);
        System.out.println("highp的值"+highp);
        System.out.println("subject的值"+subject);

        HashMap<String,String> map = new HashMap<>();
        map.put("subject",subject);
        map.put("lowprice",lowp);
        map.put("highprice",highp);
        System.out.println(map+"日志map::::::::::::::::");

        //接收参数,当前页
        String pageNoStr = req.getParameter("pageNo");
        System.out.println("日志:pageNoStr的值 "+ pageNoStr);
        int pageNo =  Integer.parseInt(pageNoStr);

        //总条数
        int total = activityService.count(map);
        PageUtil pageUtil = new PageUtil(pageNo,total);

        List<Activity> list = activityService.findAll(pageUtil,map);
        System.out.println("日志:Contract.doget"+list);

        req.setAttribute("list",list);
        System.out.println("list的数据为"+list);
        req.setAttribute("pageUtil",pageUtil);
        req.setAttribute("map",map);
        //查询全部后进入页面
        req.getRequestDispatcher("/view/activity/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
