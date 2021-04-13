package com.zzx.servlet.rent;

import com.zzx.model.Contract;
import com.zzx.model.Rent;
import com.zzx.service.ContractService;
import com.zzx.service.RentService;
import com.zzx.service.impl.RentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RentUpdateServlet extends HttpServlet {
    private RentService rentService = new RentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收数据
        int cid = Integer.parseInt(req.getParameter("rid"));

        // 调用Service处理
        Rent rent = rentService.findLesseeById(cid);

        // 将数据存入Session域
        req.getSession().setAttribute("rent",rent);
        //查询完毕后将数据回显的该页面
        req.getRequestDispatcher("/view/rent/update.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式,防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //接收前台传过来的数据
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收参数
        int rid = Integer.parseInt(req.getParameter("rid"));
        int rhid = Integer.parseInt(req.getParameter("rhid"));
        int rlid = Integer.parseInt(req.getParameter("rlid"));
        Double price = Double.valueOf(req.getParameter("rprice"));
        String rpay = req.getParameter("rpayTime");


        // 封装数据
        Rent rent = new Rent();
        rent.setRid(rid);
        rent.setRhid(rhid);
        rent.setRlid(rlid);
        rent.setRprice(price);
        Date time = null;
        try {
            time = new SimpleDateFormat("yyyy-MM-dd").parse(rpay);
        } catch (Exception e) {
            e.printStackTrace();
        }
        rent.setRpayTime(time);

        //日志:看是否将数据写入
        System.out.println("郑子轩的Rent表的修改单条数据日志"+rent);

        rentService.findUpdateLesseeById(rent);

        //添加完信息返回页面查全部
        resp.sendRedirect(req.getContextPath()+"/user/rent/selectall?pageNo=1");
    }


}
