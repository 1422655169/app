package com.zzx.servlet.logi;

import com.zzx.service.LogiService;
import com.zzx.service.impl.LogiServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogiDeleteOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 接收参数
        int loid = Integer.parseInt(req.getParameter("loid"));

        // 调用业务层处理
        LogiService logiService = new LogiServiceImpl();
        logiService.findLogiByDelete(loid);

        // 然后请求转发到list重新查询数据
        resp.sendRedirect(req.getContextPath()+"/user/logi/selectall?pageNo=1");
    }
}
