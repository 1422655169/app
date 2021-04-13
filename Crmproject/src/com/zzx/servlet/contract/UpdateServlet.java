package com.zzx.servlet.contract;

import com.zzx.model.Contract;
import com.zzx.model.House;
import com.zzx.service.ContractService;
import com.zzx.service.impl.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateServlet extends HttpServlet {
    private ContractService contractService = new ContractServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收数据
        int cid = Integer.parseInt(req.getParameter("cid"));

        // 调用Service处理
        Contract contract = contractService.findContractById(cid);

        // 将数据存入Session域
        req.getSession().setAttribute("contract",contract);
        //查询完毕后将数据回显的该页面
        req.getRequestDispatcher("/view/contract/update.jsp").forward(req,resp);
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
        int cid = Integer.parseInt(req.getParameter("cid"));
        String cnum = req.getParameter("cnum");
        int chid = Integer.parseInt(req.getParameter("chid"));
        int clid = Integer.parseInt(req.getParameter("clid"));
        String ctimes = req.getParameter("ctime");
        String cstartTimes = req.getParameter("cstartTime");
        String cendTimes = req.getParameter("cendTime");
        String cto = req.getParameter("ctotalMoney");
        int cpayType = Integer.parseInt(req.getParameter("cpayType"));

        // 封装数据
        Contract contract = new Contract();
        contract.setCid(cid);
        contract.setCnum(cnum);
        contract.setChid(chid);
        contract.setClid(clid);
        Date ctime = null;
        Date cstartTime = null;
        Date cendTime = null;
        try {
            ctime = new SimpleDateFormat("yyyy-MM-dd").parse(ctimes);
            cstartTime = new SimpleDateFormat("yyyy-MM-dd").parse(cstartTimes);
            cendTime = new SimpleDateFormat("yyyy-MM-dd").parse(cendTimes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        contract.setCtime(ctime);
        contract.setCstartTime(cstartTime);
        contract.setCendTime(cendTime);
        contract.setCtotalMoney(cto);
        contract.setCpayType(cpayType);

        //日志:看是否将数据写入
        System.out.println("郑子轩的Contract表的修改单条数据日志"+contract);

        contractService.findUpdateById(contract);

        //添加完信息返回页面查全部
        resp.sendRedirect(req.getContextPath()+"/user/contract/selectall?pageNo=1");
    }
}
