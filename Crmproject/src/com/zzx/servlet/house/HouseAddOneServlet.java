package com.zzx.servlet.house;
/**
 * 这里是house的添加功能
 */
import com.zzx.model.House;
import com.zzx.model.User;
import com.zzx.service.HouseService;
import com.zzx.service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HouseAddOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式,防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //接收前台传过来的数据
        String haddress = req.getParameter("haddress");
        String hfloor = req.getParameter("hfloor");
        int hroomNum = Integer.parseInt(req.getParameter("hroomNum"));
        String harea = req.getParameter("harea");
        String hdir = req.getParameter("hdir");
        int hdeco = Integer.parseInt(req.getParameter("hdeco"));
        int hair = Integer.parseInt(req.getParameter("hair"));
        Double hprice = Double.valueOf(req.getParameter("hprice"));
        int hrent = Integer.parseInt(req.getParameter("hrentStatus"));
        String image = req.getParameter("himage");
        String haddTime = req.getParameter("haddTime");
        String hupdateTime = req.getParameter("hupdateTime");

        //封装数据
        House house = new House();
        house.setHaddress(haddress);
        house.setHfloor(hfloor);
        house.setHroomNum(hroomNum);
        house.setHarea(harea);
        house.setHdir(hdir);
        house.setHdeco(hdeco);
        house.setHair(hair);
        house.setHprice(hprice);
        house.setHrentStatus(hrent);
        house.setHimage(image);
        Date hadtime = null;
        try {
            hadtime = new SimpleDateFormat("yyyy-MM-dd").parse(haddTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        house.setHaddTime(hadtime);
        Date update = null;
        try {
            update= new SimpleDateFormat("yyyy-MM-dd").parse(hupdateTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        house.setHupdateTime(update);
        //日志:看是否将数据写入
        System.out.println("郑子轩的house表的添加单条数据日志"+house);

        //调用Service层处理
        HouseService houseService = new HouseServiceImpl();
        houseService.addOne(house);
        System.out.println("调用HouseService中的AddOne方法成功");

        //添加完信息返回页面查全部
        resp.sendRedirect(req.getContextPath()+"/user/house/show?pageNo=1");
       // req.getRequestDispatcher("/view/house/list.jsp").forward(req,resp);
    }
}
