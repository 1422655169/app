package com.zzx.servlet.contract;

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
import java.util.ArrayList;

public class SelectAllServlet extends HttpServlet {

    private ContractService contractService = new ContractServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //接收查询到的关键字
        String keyword = req.getParameter("keyword");
        System.out.println("郑子轩的日志show:keyword " +keyword);

        //当前页
        int page = Integer.parseInt(req.getParameter("page"));

        //调用业务层,查询共多少条记录
        int total = contractService.count(keyword);

        //分页工具类
        PageUtil pageUtil = new PageUtil(page,total);

        //调用HouseService层处理
        ArrayList<Contract> list = contractService.SelectAll(pageUtil);

        //存入Session域中
        req.getSession().setAttribute("list",list);
        req.getSession().setAttribute("pageUtil",pageUtil);

        //查询全部后进入页面
        req.getRequestDispatcher("/view/contract/show.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
