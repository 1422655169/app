package com.zzx.servlet.logi;

import com.zzx.model.Logi;
import com.zzx.service.LogiService;
import com.zzx.service.impl.LogiServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogiAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收数据
        String loname = req.getParameter("loname");
        String loidCard = req.getParameter("loidCard");
        String lotel = req.getParameter("lotel");
        int losex = Integer.parseInt(req.getParameter("losex"));
        String loaddTimes = req.getParameter("loaddTime");
        Double losalary = Double.valueOf(req.getParameter("losalary"));

        // 封装数据
        Logi logi = new Logi();
        logi.setLoname(loname);
        logi.setLoidCard(loidCard);
        logi.setLotel(lotel);
        logi.setLosex(losex);
        Date loaddTime = null;
        try {
            loaddTime = new SimpleDateFormat("yyyy-MM-dd").parse(loaddTimes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logi.setLoaddTime(loaddTime);
        logi.setLosalary(losalary);

        // 调用业务层处理
        LogiService logiService = new LogiServiceImpl();
        logiService.findLogiByAdd(logi);

        // 返回页面
        resp.sendRedirect(req.getContextPath()+"/user/logi/selectall?pageNo=1");

    }



}
