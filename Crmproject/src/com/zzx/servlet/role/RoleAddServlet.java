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

public class RoleAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收参数
        String roname = req.getParameter("roname");
        String rodesc = req.getParameter("rodesc");
        String roaddTimes = req.getParameter("roaddTime");

        // 封装数据
        Role role = new Role();
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
        roleService.findRoleByAdd(role);

        //添加完信息返回页面查全部
        resp.sendRedirect(req.getContextPath()+"/user/role/selectall?page=1");
    }
}
