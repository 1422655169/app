package com.zzx.servlet.rent;

import com.zzx.model.Rent;
import com.zzx.service.RentService;
import com.zzx.service.impl.RentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RentAddOneServlet extends HttpServlet {
    private RentService rentService  = new RentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //设置编码格式,防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //接收前台传过来的数据
        int rhid = Integer.parseInt(req.getParameter("rhid"));
        int rlid = Integer.parseInt(req.getParameter("rlid"));
        Double rprice = Double.valueOf(req.getParameter("rprice"));
        String rpay = req.getParameter("rpayTime");

        //封装数据
        Rent rent = new Rent();
        rent.setRhid(rhid);
        rent.setRlid(rlid);
        rent.setRprice(rprice);
        Date time = null;
        try {
            time = new SimpleDateFormat("yyyy-MM-dd").parse(rpay);
        }catch (Exception e){
            e.printStackTrace();
        }
        rent.setRpayTime(time);


        //日志:看是否将数据写入
        System.out.println("郑子轩的Contract表的添加单条数据日志"+rent);

        //调用Service层处理
        rentService.addone(rent);
        System.out.println("调用RentService中的AddOne方法成功");

        //添加完信息返回页面查全部
        resp.sendRedirect(req.getContextPath()+"/user/rent/selectall?pageNo=1");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
