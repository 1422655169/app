package com.zzx.servlet.contract;

import com.zzx.service.ContractService;
import com.zzx.service.HouseService;
import com.zzx.service.impl.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收前台传过来的数据
        int idone = Integer.parseInt(req.getParameter("cid"));
        System.out.println("郑子轩的日志:DeleteOne获得到的数据是 : " +idone);

        //调用HouseService层处理
        ContractService contractService = new ContractServiceImpl();
        contractService.DeleteOne(idone);

        // 然后请求转发到list重新查询数据
        resp.sendRedirect(req.getContextPath()+"/user/contract/selectall?pageNo=1");
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
}
