package com.zzx.servlet.activity;

import com.zzx.service.ActivityService;
import com.zzx.service.impl.ActivityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ActivityDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收参数
        int aid = Integer.parseInt(req.getParameter("aid"));

        // 调用业务层处理
        ActivityService activityService = new ActivityServiceImpl();
        activityService.findActivityByDelete(aid);

        //添加完信息返回页面查全部
        resp.sendRedirect(req.getContextPath()+"/user/activity/selectall?pageNo=1");


    }
}
