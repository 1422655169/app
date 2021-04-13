package com.zzx.servlet.role;

import com.zzx.model.Role;
import com.zzx.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RoleUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收参数
        int roid = Integer.parseInt(req.getParameter("roid"));

        // 调用业务层处理
        RoleService roleService = new RoleService();
        Role role = roleService.findRoleById(roid);

        // 将数据保存
        req.getSession().setAttribute("role",role);

        // 回显
        req.getRequestDispatcher("/view/role/update.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收参数
        int roid = Integer.parseInt(req.getParameter("roid"));
        String roname = req.getParameter("roname");
        String rodesc = req.getParameter("rodesc");
        String roaddTimes = req.getParameter("roaddTime");

        // 封装数据
        Role role = new Role();
        role.setRoid(roid);
        role.setRoname(roname);
        role.setRodesc(rodesc);
        Date roaddTime = null;
        try {
            roaddTime = new SimpleDateFormat("yyyy-MM-dd").parse(roaddTimes);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        role.setRoaddTime(roaddTime);

        // 调用业务层处理
        RoleService roleService = new RoleService();
        roleService.findRoleByUpdate(role);

        //添加完信息返回页面查全部
        resp.sendRedirect(req.getContextPath()+"/user/role/selectall?page=1");
    }
}
