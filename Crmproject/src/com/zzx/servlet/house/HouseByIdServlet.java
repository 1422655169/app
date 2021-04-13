package com.zzx.servlet.house;

import com.zzx.model.House;
import com.zzx.service.HouseService;
import com.zzx.service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HouseByIdServlet extends HttpServlet {

    private HouseService houseService = new HouseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //接收参数
        int id = Integer.parseInt(req.getParameter("hid"));

        //调用HouseService层处理
        //House house  = houseService.seleteById(id);
        // 调用Service层处理
        House house = houseService.findHouseById(id);


        //将数据存入到session域中
        req.getSession().setAttribute("house",house);

        //查询完毕后将数据回显的该页面
        req.getRequestDispatcher("/view/house/update.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式,防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //接收前台传过来的数据
//        int hid = Integer.parseInt(req.getParameter("hid"));
//        String haddress = req.getParameter("haddress");
//        String hfloor = req.getParameter("hfloor");
//        int hroomNum = Integer.parseInt(req.getParameter("hroomNum"));
//        String harea = req.getParameter("harea");
//        String hdir = req.getParameter("hdir");
//        int hdeco = Integer.parseInt(req.getParameter("hdeco"));
//        int hair = Integer.parseInt(req.getParameter("hair"));
//        Double hprice = Double.valueOf(req.getParameter("hprice"));
//        int hrent = Integer.parseInt(req.getParameter("hrentStatus"));
//        String images = req.getParameter("himage");
//        String haddTime = req.getParameter("haddTime");
//        String hupdateTime = req.getParameter("hupdateTime");
        int hid = Integer.parseInt(req.getParameter("hid"));
        String haddress = req.getParameter("haddress");
        String hfloor = req.getParameter("hfloor");
        int hroomNun = Integer.parseInt(req.getParameter("hroomNum"));
        String harea = req.getParameter("harea");
        String hdir = req.getParameter("hdir");
        int hdeco = Integer.parseInt(req.getParameter("hdeco"));
        int hair = Integer.parseInt(req.getParameter("hair"));
        Double hprice = Double.valueOf((req.getParameter("hprice")));
        int hrentStatus = Integer.parseInt(req.getParameter("hrentStatus"));
        String himage = req.getParameter("himage");
        String haddTimes = req.getParameter("haddTime");
        String hupdateTimes = req.getParameter("hupdateTime");


        //封装数据
//        House house = new House();
//        house.setHid(hid);
//        house.setHaddress(haddress);
//        house.setHfloor(hfloor);
//        house.setHroomNum(hroomNum);
//        house.setHarea(harea);
//        house.setHdir(hdir);
//        house.setHdeco(hdeco);
//        house.setHair(hair);
//        house.setHprice(hprice);
//        house.setHrentStatus(hrent);
//        house.setHimage(images);
//        Date hadtime = null;
//        try {
//            hadtime = new SimpleDateFormat("yyyy-MM-dd").parse(haddTime);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        house.setHaddTime(hadtime);
//        Date update = null;
//        try {
//            update= new SimpleDateFormat("yyyy-MM-dd").parse(hupdateTime);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        house.setHupdateTime(update);

        // 封装数据
        House house = new House();
        house.setHid(hid);
        house.setHaddress(haddress);
        house.setHfloor(hfloor);
        house.setHroomNum(hroomNun);
        house.setHarea(harea);
        house.setHdir(hdir);
        house.setHdeco(hdeco);
        house.setHair(hair);
        house.setHprice(hprice);
        house.setHrentStatus(hrentStatus);
        house.setHimage(himage);
        Date haddTime = null;
        try {
            haddTime = new SimpleDateFormat("yyyy-MM-dd").parse(haddTimes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        house.setHaddTime(haddTime);
        Date hupdateTime = null;
        try {
            hupdateTime = new SimpleDateFormat("yyyy-MM-dd").parse(hupdateTimes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        house.setHupdateTime(hupdateTime);

        // 调用Service层处理
        houseService.findUpdateHouseById(house);


        //日志:看是否将数据写入
        System.out.println("郑子轩的house表的修改单条数据日志"+house);

        //调用HouseService层做处理
       // houseService.update(house);

        //更新数据后,将数据刷新
        resp.sendRedirect(req.getContextPath()+"/user/house/show?pageNo=1");
    }
}
