package com.zzx.servlet.lessee;

import com.zzx.model.Lessee;
import com.zzx.service.HouseService;
import com.zzx.service.LesseeService;
import com.zzx.service.impl.HouseServiceImpl;
import com.zzx.service.impl.LesseeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LesseeAddOneServlet extends HttpServlet {
    private LesseeService lesseeService = new LesseeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式,防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //接收前台传过来的数据
        String name = req.getParameter("lname");
        String tel = req.getParameter("ltel");
        int sex = Integer.parseInt(req.getParameter("lsex"));
        String np = req.getParameter("lnp");
        String idcard = req.getParameter("lidCard");
        String addTime = req.getParameter("laddTime");

        //封装数据
        Lessee lessee = new Lessee();
        lessee.setLname(name);
        lessee.setLtel(tel);
        lessee.setLsex(sex);
        lessee.setLnp(np);
        lessee.setLidCard(idcard);
        Date Laddtime = null;
        try {
            Laddtime = new SimpleDateFormat("yyyy-MM-dd").parse(addTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        lessee.setLaddTime(Laddtime);

        //日志:看是否将数据写入
        System.out.println("郑子轩的house表的添加单条数据日志"+lessee);

        //调用Service层处理
        HouseService houseService = new HouseServiceImpl();
        lesseeService.AddOne(lessee);
        System.out.println("调用LesseeService中的AddOne方法成功");

        //添加完信息返回页面查全部
        resp.sendRedirect(req.getContextPath()+"/user/lessee/selectall?pageNo=1");
        // req.getRequestDispatcher("/view/house/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
