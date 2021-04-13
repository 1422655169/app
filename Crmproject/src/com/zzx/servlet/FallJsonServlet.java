package com.zzx.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zzx.model.MxBean;
import com.zzx.util.DBTool;


public class FallJsonServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //请求发送都是utf-8 
		 request.setCharacterEncoding("UTF-8");
         response.setCharacterEncoding("UTF-8");
         
		List<MxBean> list = new ArrayList<MxBean>();
		DBTool dbt = new DBTool();
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String json = null;
		try {
			conn = dbt.getConnection();
			String sql = "SELECT xh,jyrq,yelx,bz,crje,zqje,zhye,dfzh,dfxm,dfkhh,fy,zy  FROM t_yw_mx order by  ( xh + 0) asc ";
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MxBean mxBean = new MxBean();
				mxBean.setXh(rs.getString("xh"));
				mxBean.setJyrq(rs.getString("jyrq"));
				mxBean.setYelx(rs.getString("yelx"));
				
				mxBean.setBz(rs.getString("bz"));
				mxBean.setCrje(rs.getString("crje"));
				mxBean.setZqje(rs.getString("zqje"));
				
				mxBean.setZhye(rs.getString("zhye"));
				mxBean.setDfzh(rs.getString("dfzh"));
				mxBean.setDfxm(rs.getString("dfxm"));
				
				mxBean.setDfkhh(rs.getString("dfkhh"));
				mxBean.setFy(rs.getString("fy"));
				mxBean.setZy(rs.getString("zy"));
				
				list.add(mxBean);
			}

			json = JSON.toJSONString(list);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
