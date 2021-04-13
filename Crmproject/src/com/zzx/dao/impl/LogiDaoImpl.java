package com.zzx.dao.impl;

import com.zzx.dao.LogiDao;
import com.zzx.model.Logi;
import com.zzx.util.DBUtil;
import com.zzx.util.PageUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LogiDaoImpl implements LogiDao {
    /**
     * 这里是查询全部
     * @param pageUtil
     * @return
     */

    @Override
    public List<Logi> findAll(PageUtil pageUtil, HashMap<String, String> map) {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Logi> list = new ArrayList<>();
        String sql ="select * from logi where loname like concat(\"%\",?,\"%\")  limit ?,?";
        try {
            String loname = map.get("loname");
            ps = con.prepareStatement(sql);
            System.out.println("UserDaoImpl.findAll 1 ps = "+ps );
            // 设置参数
            ps.setString(1,loname == null ? "":loname );
            ps.setInt(2,pageUtil.getStart());
            ps.setInt(3,pageUtil.getEnd());
            System.out.println("UserDaoImpl.findAll 2 ps = "+ps );
            rs = ps.executeQuery();
            while (rs.next()){
                Logi logi = new Logi();
                logi.setLoid(rs.getInt("loid"));
                logi.setLoname(rs.getString("loname"));
                logi.setLoidCard(rs.getString("loidCard"));
                logi.setLotel(rs.getString("lotel"));
                logi.setLosex(rs.getInt("losex"));
                logi.setLoaddTime(rs.getDate("loaddTime"));
                logi.setLosalary(rs.getDouble("losalary"));
                list.add(logi);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return list;
    }
    //这里是获取数据条数的
    @Override
    public int count(HashMap<String, String> map) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select count(*) total from logi " +
                "where loname like concat(\"%\",?,\"%\")";
        int total = 0;
        String usname = map.get("loname");
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,usname == null ? "":usname );
            rs = ps.executeQuery();
            if(rs.next()){
                total = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DBUtil.closeAll(conn,ps,rs);
        return total;
    }

    public ArrayList<Logi> SelectAll(PageUtil pageUtil){
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Logi> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from logi");

        sql.append(" limit "+pageUtil.getStart()+","+pageUtil.getEnd()+"");
        try {
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()){
                Logi logi = new Logi();
                logi.setLoid(rs.getInt("loid"));
                logi.setLoname(rs.getString("loname"));
                logi.setLoidCard(rs.getString("loidCard"));
                logi.setLotel(rs.getString("lotel"));
                logi.setLosex(rs.getInt("losex"));
                logi.setLoaddTime(rs.getDate("loaddTime"));
                logi.setLosalary(rs.getDouble("losalary"));
                list.add(logi);
            }
            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return list;
    }

    public int count(String keyword){
        Connection con = DBUtil.getConnection();
        int total = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            StringBuilder ssql = new StringBuilder("select count(*) as total from logi");
            ps = con.prepareStatement(ssql.toString());
            rs = ps.executeQuery();
            while (rs.next()){
                total = rs.getInt("total");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return total;
    }

    /**
     * 删除数据
     * @param loid
     */
    public void findLogiByDelete(int loid) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from logi where loid=?");
            ps.setInt(1,loid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps);
        }
    }

    /**
     * 添加数据
     * @param logi
     */
    public void findLogiByAdd(Logi logi) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("insert into logi (loname,loidCard,lotel,losex,loaddTime,losalary) values (?,?,?,?,?,?)");
            ps.setString(1,logi.getLoname());
            ps.setString(2,logi.getLoidCard());
            ps.setString(3,logi.getLotel());
            ps.setInt(4,logi.getLosex());
            ps.setDate(5,new java.sql.Date(logi.getLoaddTime().getTime()));
            ps.setDouble(6,logi.getLosalary());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps);
        }
    }

    public Logi findLogiById(int loid) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Logi logi = null;
        try {
            ps = conn.prepareStatement("select * from logi where loid=?");
            ps.setInt(1,loid);
            rs = ps.executeQuery();
            while (rs.next()) {
                logi = new Logi();
                logi.setLoid(rs.getInt("loid"));
                logi.setLoname(rs.getString("loname"));
                logi.setLoidCard(rs.getString("loidCard"));
                logi.setLotel(rs.getString("lotel"));
                logi.setLosex(rs.getInt("losex"));
                logi.setLoaddTime(rs.getDate("loaddTime"));
                logi.setLosalary(rs.getDouble("losalary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps,rs);
        }
        return logi;
    }

    public void findLogiByUpdate(Logi logi) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update logi set loname=?,loidCard=?,lotel=?,losex=?,loaddTime=?,losalary=? where loid=?");
            ps.setString(1,logi.getLoname());
            ps.setString(2,logi.getLoidCard());
            ps.setString(3,logi.getLotel());
            ps.setInt(4,logi.getLosex());
            ps.setDate(5,new java.sql.Date(logi.getLoaddTime().getTime()));
            ps.setDouble(6,logi.getLosalary());
            ps.setInt(7,logi.getLoid());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps);
        }
    }


}
