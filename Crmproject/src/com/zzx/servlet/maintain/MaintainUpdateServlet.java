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

public class MaintainUpdateServlet extends HttpServlet {

    private MaintainService maintainService = new MaintainService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收数据
        int mid = Integer.parseInt(req.getParameter("mid"));

        // 调用业务层处理
        Maintain maintain = maintainService.findMaintainById(mid);

        // 保存数据
        req.getSession().setAttribute("maintain",maintain);

        // 回显
        req.getRequestDispatcher("/view/maintain/update.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收数据
        int mid = Integer.parseInt(req.getParameter("mid"));
        int mhid = Integer.parseInt(req.getParameter("mhid"));
        int mloid = Integer.parseInt(req.getParameter("mloid"));
        String mtimes = req.getParameter("mtime");
        String mresult = req.getParameter("mresult");

        // 封装数据
        Maintain maintain = new Maintain();
        maintain.setMid(mid);
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
        maintainService.findMaintainByUpdate(maintain);

        // 返回页面
        resp.sendRedirect(req.getContextPath()+"/user/maintain/selectall?page=1");

    }
}
