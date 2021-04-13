package com.zzx.servlet.contract;

import com.zzx.model.Contract;
import com.zzx.model.House;
import com.zzx.service.ContractService;
import com.zzx.service.HouseService;
import com.zzx.service.impl.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddOne  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式,防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //接收前台传过来的数据
        String cnum = req.getParameter("cnum");
        int chid = Integer.parseInt(req.getParameter("chid"));
        int clid = Integer.parseInt(req.getParameter("clid"));
        String ctime = req.getParameter("ctime");
        String csTime = req.getParameter("cstartTime");
        String ceTime = req.getParameter("cendTime");
        String cto = req.getParameter("ctotalMoney");
        int cpa = Integer.parseInt(req.getParameter("cpayType"));
        //封装数据
        Contract act = new Contract();
        act.setCnum(cnum);
        act.setChid(chid);
        act.setClid(clid);
        Date time = null;
        try {
            time = new SimpleDateFormat("yyyy-MM-dd").parse(ctime);
        }catch (Exception e){
            e.printStackTrace();
        }
        act.setCtime(time);
        Date cstime = null;
        try {
            cstime= new SimpleDateFormat("yyyy-MM-dd").parse(csTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        act.setCstartTime(cstime);
        Date cetime = null;
        try {
            cetime= new SimpleDateFormat("yyyy-MM-dd").parse(ceTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        act.setCendTime(cetime);
        act.setCtotalMoney(cto);
        act.setCpayType(cpa);

        //日志:看是否将数据写入
        System.out.println("郑子轩的Contract表的添加单条数据日志"+act);

        //调用Service层处理
        ContractService contractService = new ContractServiceImpl();
        contractService.AddOne(act);
        System.out.println("调用ContractService中的AddOne方法成功");

        //添加完信息返回页面查全部
        resp.sendRedirect(req.getContextPath()+"/user/contract/selectall?pageNo=1");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
