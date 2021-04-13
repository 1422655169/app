package com.zzx.servlet.role;



import com.zzx.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RoleDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 接收参数
        int roid = Integer.parseInt(req.getParameter("roid"));

        // 调用业务层处理
        RoleService roleService = new RoleService();
        roleService.findRoleByDelete(roid);

        //添加完信息返回页面查全部
        resp.sendRedirect(req.getContextPath()+"/user/role/selectall?page=1");
    }
}
