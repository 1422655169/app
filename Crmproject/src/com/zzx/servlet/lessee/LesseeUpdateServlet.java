package com.zzx.servlet.lessee;

import com.zzx.model.House;
import com.zzx.model.Lessee;
import com.zzx.service.LesseeService;
import com.zzx.service.impl.LesseeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LesseeUpdateServlet extends HttpServlet {
    private LesseeService lesseeService = new LesseeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        int id = Integer.parseInt(req.getParameter("lid"));

        // 调用Service层处理
        Lessee lessee = lesseeService.findContractById(id);

        //将数据存入到session域中
        req.getSession().setAttribute("lessee",lessee);

        //查询完毕后将数据回显的该页面
        req.getRequestDispatcher("/view/lesseee/update.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式,防止乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        int lid = Integer.parseInt(req.getParameter("lid"));
        String name = req.getParameter("lname");
        String tel = req.getParameter("ltel");
        int sex = Integer.parseInt(req.getParameter("lsex"));
        String lnp = req.getParameter("lnp");
        String Card = req.getParameter("lidCard");
        String addTimes = req.getParameter("laddTime");

        //封装数据
        Lessee lessee = new Lessee();
        lessee.setLid(lid);
        lessee.setLname(name);
        lessee.setLtel(tel);
        lessee.setLsex(sex);
        lessee.setLnp(lnp);
        lessee.setLidCard(Card);
        Date time = null;
        try {
            time = new SimpleDateFormat("yyyy-MM-dd").parse(addTimes);
        }catch (Exception e){
            e.printStackTrace();
        }
        lessee.setLaddTime(time);

        //调用LesseeService层做处理
        lesseeService.findUpdateById(lessee);

        //更新数据后,将数据刷新
        resp.sendRedirect(req.getContextPath()+"/user/lessee/selectall?pageNo=1");
    }
}
