package com.zzx.servlet.activity;

import com.zzx.model.Activity;
import com.zzx.service.ActivityService;
import com.zzx.service.impl.ActivityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收数据
        String atimes = req.getParameter("atime");
        String asubject = req.getParameter("asubject");
        String aintr = req.getParameter("aintr");
        String aaddress = req.getParameter("aaddress");
        Double aprice = Double.valueOf(req.getParameter("aprice"));

        // 封装数据
        Activity activity = new Activity();
        Date atime = null;
        try {
            atime = new SimpleDateFormat("yyyy-MM-dd").parse(atimes);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        activity.setAtime(atime);
        activity.setAsubject(asubject);
        activity.setAintr(aintr);
        activity.setAaddress(aaddress);
        activity.setAprice(aprice);

        // 调用业务层处理
        ActivityService activityService = new ActivityServiceImpl();
        activityService.findActivityByAdd(activity);

        //添加完信息返回页面查全部
        resp.sendRedirect(req.getContextPath()+"/user/activity/selectall?pageNo=1");
    }
}
