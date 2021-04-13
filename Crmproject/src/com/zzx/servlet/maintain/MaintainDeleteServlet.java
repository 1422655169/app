package com.zzx.servlet.maintain;

import com.zzx.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MaintainDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 接收参数
        int mid = Integer.parseInt(req.getParameter("mid"));

        // 调用业务层处理
        MaintainService maintainService = new MaintainService();
        maintainService.findMaintainByDelete(mid);

        // 然后请求转发到list重新查询数据
        resp.sendRedirect(req.getContextPath()+"/user/maintain/selectall?page=1");
    }
}
