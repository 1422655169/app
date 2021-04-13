package com.zzx.servlet.contract;

import com.sun.org.apache.xpath.internal.compiler.Keywords;
import com.zzx.model.Contract;
import com.zzx.model.House;
import com.zzx.service.ContractService;
import com.zzx.service.impl.ContractServiceImpl;
import com.zzx.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ContractServlet extends HttpServlet {

    private ContractService contractService = new ContractServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收前端传过来的关键字
        String lowp = req.getParameter("lowprice");
        String highp = req.getParameter("highprice");
        System.out.println("lowp的值"+lowp);
        System.out.println("highp的值"+highp);


        HashMap<String,String> map = new HashMap<>();
        map.put("lowprice",lowp);
        map.put("highprice",highp);
        System.out.println(map+"日志map::::::::::::::::");

        //接收参数,当前页
        String pageNoStr = req.getParameter("pageNo");
        System.out.println("日志:pageNoStr的值 "+ pageNoStr);
        int pageNo =  Integer.parseInt(pageNoStr);

        //总条数
        int total = contractService.count(map);
        PageUtil pageUtil = new PageUtil(pageNo,total);

        List<Contract> list = contractService.findAll(pageUtil,map);
        System.out.println("日志:Contract.doget"+list);

        req.setAttribute("list",list);
        req.setAttribute("pageUtil",pageUtil);
        req.setAttribute("keywordMap",map);

        //查询全部后进入页面
        req.getRequestDispatcher("/view/contract/show.jsp").forward(req,resp);
    }
}
