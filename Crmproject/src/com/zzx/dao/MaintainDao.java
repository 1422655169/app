package com.zzx.dao;

import com.zzx.model.Lessee;
import com.zzx.model.Maintain;
import com.zzx.util.DBUtil;
import com.zzx.util.PageUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaintainDao {

    /**
     * 这里是查询全部
     * @param pageUtil
     * @return
     */
    public ArrayList<Maintain> SelectAll(PageUtil pageUtil){
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Maintain> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from maintain");

        sql.append(" limit "+pageUtil.getStart()+","+pageUtil.getEnd()+"");
        try {
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Maintain maintain = new Maintain();
                maintain.setMid(rs.getInt("mid"));
                maintain.setMhid(rs.getInt("mhid"));
                maintain.setMloid(rs.getInt("mloid"));
                maintain.setMtime(rs.getDate("mtime"));
                maintain.setMresult(rs.getString("mresult"));
                list.add(maintain);
            }

            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return list;
    }
    //这里是获取数据条数的
    public int count(String keyword){
        Connection con = DBUtil.getConnection();
        int total = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            StringBuilder ssql = new StringBuilder("select count(*) as total from maintain");
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
     * @param mid
     */
    public void findMaintainByDelete(int mid) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from maintain where mid=?");
            ps.setInt(1,mid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps);
        }
    }
    /**
     * 添加数据
     * @param maintain
     */
    public void findMaintainByAdd(Maintain maintain) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("insert into maintain (mhid,mloid,mtime,mresult) values (?,?,?,?)");
            ps.setInt(1,maintain.getMhid());
            ps.setInt(2,maintain.getMloid());
            ps.setDate(3,new java.sql.Date(maintain.getMtime().getTime()));
            ps.setString(4,maintain.getMresult());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps);
        }
    }

    /**
     * 更新前查询数据
     * @param mid
     * @return
     */
    public Maintain findMaintainById(int mid) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Maintain maintain = null;
        try {
            ps = conn.prepareStatement("select * from maintain where mid=?");
            ps.setInt(1,mid);
            rs = ps.executeQuery();
            while (rs.next()) {
                maintain = new Maintain();
                maintain.setMid(rs.getInt("mid"));
                maintain.setMhid(rs.getInt("mhid"));
                maintain.setMloid(rs.getInt("mloid"));
                maintain.setMtime(rs.getDate("mtime"));
                maintain.setMresult(rs.getString("mresult"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps,rs);
        }
        return maintain;
    }

    /**
     * 更新数据
     * @param maintain
     */
    public void findMaintainByUpdate(Maintain maintain) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update maintain set mhid=?,mloid=?,mtime=?,mresult=? where mid=?");
            ps.setInt(1,maintain.getMhid());
            ps.setInt(2,maintain.getMloid());
            ps.setDate(3,new java.sql.Date(maintain.getMtime().getTime()));
            ps.setString(4,maintain.getMresult());
            ps.setInt(5,maintain.getMid());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps);
        }
    }
}
