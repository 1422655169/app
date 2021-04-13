package com.zzx.servlet.lessee;
import com.zzx.service.LesseeService;
import com.zzx.service.impl.LesseeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LesseeDeleteOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收前台传过来的数据
        int idone = Integer.parseInt(req.getParameter("lid"));
        System.out.println("郑子轩的日志:DeleteOne获得到的数据是 : " +idone);

        //调用HouseService层处理
        LesseeService lesseeService = new LesseeServiceImpl();
        lesseeService.DeleteOne(idone);

        // 然后请求转发到list重新查询数据
        resp.sendRedirect(req.getContextPath()+"/user/lessee/selectall?pageNo=1");
    }





}
