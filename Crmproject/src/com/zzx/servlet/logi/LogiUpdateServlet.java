package com.zzx.servlet.logi;

import com.zzx.model.Logi;
import com.zzx.service.LogiService;
import com.zzx.service.impl.LogiServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogiUpdateServlet extends HttpServlet {
    private LogiService logiService = new LogiServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收数据
        int loid = Integer.parseInt(req.getParameter("loid"));

        //  调用业务层处理
        Logi logi =  logiService.findLogiById(loid);

        // 将数据保存
        req.getSession().setAttribute("logi",logi);

        // 回显
        req.getRequestDispatcher("/view/logi/update.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收数据
        int loid = Integer.parseInt(req.getParameter("loid"));
        String loname = req.getParameter("loname");
        String loidCard = req.getParameter("loidCard");
        String lotel = req.getParameter("lotel");
        int losex = Integer.parseInt(req.getParameter("losex"));
        String loaddTimes = req.getParameter("loaddTime");
        Double losalary = Double.valueOf(req.getParameter("losalary"));

        // 封装数据
        Logi logi = new Logi();
        logi.setLoid(loid);
        logi.setLoname(loname);
        logi.setLoidCard(loidCard);
        logi.setLotel(lotel);
        logi.setLosex(losex);
        Date loaddTime = null;
        try {
            loaddTime = new SimpleDateFormat("yyyy-MM-dd").parse(loaddTimes);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        logi.setLoaddTime(loaddTime);
        logi.setLosalary(losalary);

        // 调用业务层处理
        logiService.findLogiByUpdate(logi);

        // 返回页面
        resp.sendRedirect(req.getContextPath()+"/user/logi/selectall?pageNo=1");


    }




}
