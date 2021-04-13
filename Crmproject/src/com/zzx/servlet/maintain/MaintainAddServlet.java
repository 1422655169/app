package com.zzx.servlet.maintain;

import com.zzx.model.Maintain;
import com.zzx.service.MaintainService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MaintainAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收数据
        int mhid = Integer.parseInt(req.getParameter("mhid"));
        int mloid = Integer.parseInt(req.getParameter("mloid"));
        String mtimes = req.getParameter("mtime");
        String mresult = req.getParameter("mresult");

        // 封装数据
        Maintain maintain = new Maintain();
        maintain.setMhid(mhid);
        maintain.setMloid(mloid);
        Date mtime = null;
        try {
            mtime = new SimpleDateFormat("yyyy-MM-dd").parse(mtimes);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        maintain.setMtime(mtime);
        maintain.setMresult(mresult);
        // 调用业务层处理
        MaintainService maintainService = new MaintainService();
        maintainService.findMaintainByAdd(maintain);

        // 返回页面
        resp.sendRedirect(req.getContextPath()+"/user/maintain/selectall?page=1");
    }
}
