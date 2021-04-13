package com.zzx.dao.impl;

import com.zzx.dao.LesseeDao;
import com.zzx.model.Lessee;
import com.zzx.util.DBUtil;
import com.zzx.util.PageUtil;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LesseeDaoImpl implements LesseeDao {
    /**
     * 这里是查询全部
     * @param pageUtil
     * @return
     */
    @Override
    public ArrayList<Lessee> SelectAll(PageUtil pageUtil, HashMap<String, String> keywordMap) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Lessee> ls = new ArrayList<>();
        String sql = "select lid,lname,ltel,lsex,lnp,lidCard,laddTime from lessee " +
                " where lname like concat(\"%\",?,\"%\") limit ?,?";
        try {
            String name = keywordMap.get("Lname");

            ps = conn.prepareStatement(sql);
            System.out.println("UserDaoImpl.findAll 1 ps = "+ps );
            // 设置参数
            ps.setString(1,name == null ? "":name );
            ps.setInt(2,pageUtil.getStart());
            ps.setInt(3,pageUtil.getEnd());
            System.out.println("LesseeDaoImpl.findAll 2 ps = "+ps );
            rs = ps.executeQuery();
            while(rs.next()){
                Lessee lessee = new Lessee();
                lessee.setLid(rs.getInt("lid"));
                lessee.setLname(rs.getString("lname"));
                lessee.setLtel(rs.getString("ltel"));
                lessee.setLsex(rs.getInt("lsex"));
                lessee.setLnp(rs.getString("lnp"));
                lessee.setLidCard(rs.getString("lidCard"));
                lessee.setLaddTime(rs.getDate("laddTime"));
                ls.add(lessee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DBUtil.closeAll(conn,ps,rs);
        return ls;
    }
    //这里是获取数据条数的
    public int count(HashMap<String, String> keywordMap) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select count(*) total from lessee " +
                "where lname like concat(\"%\",?,\"%\")";
        int total = 0;
        String lname = keywordMap.get("Lname");
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,lname == null ? "":lname );
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

    /**
     * 这里是Lessee表的删除功能
     * @param id
     */
    public void DeleteOne(int id) {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("delete from lessee where lid = ?");
            System.out.println("lessee的到层执行了");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps);
        }
    }
    /**
     * 这里是house表的添加功能
     * @param lessee
     */
    public void AddOne(Lessee lessee){
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("insert into lessee(lname,ltel,lsex,lnp,lidCard,laddTime) values(?,?,?,?,?,?) ");
            ps.setString(1,lessee.getLname());
            ps.setString(2,lessee.getLtel());
            ps.setInt(3,lessee.getLsex());
            ps.setString(4,lessee.getLnp());
            ps.setString(5,lessee.getLidCard());
            ps.setDate(6,new java.sql.Date(lessee.getLaddTime().getTime()));
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(con,ps);
        }
    }
    /**
     * 更新前查询数据
     * @param id
     * @return
     */
    public Lessee findContractById(int id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Lessee lessee = null;
        try {
            ps = conn.prepareStatement("select * from lessee where lid=?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                lessee = new Lessee();
                lessee.setLid(rs.getInt("lid"));
                lessee.setLname(rs.getString("lname"));
                lessee.setLtel(rs.getString("ltel"));
                lessee.setLsex(rs.getInt("lsex"));
                lessee.setLnp(rs.getString("lnp"));
                lessee.setLidCard(rs.getString("lidCard"));
                lessee.setLaddTime(rs.getDate("laddTime"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps,rs);
        }
        return lessee;
    }

    /**
     * 更新数据
     * @param lessee
     */
    public void findUpdateById(Lessee lessee) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update lessee set lname=?,ltel=?,lsex=?,lnp=?,lidCard=?,laddTime=? where lid=?");
            ps.setString(1, lessee.getLname());
            ps.setString(2, lessee.getLtel());
            ps.setInt(3, lessee.getLsex());
            ps.setString(4, lessee.getLnp());
            ps.setString(5, lessee.getLidCard());
            ps.setDate(6, new java.sql.Date(lessee.getLaddTime().getTime()));
            ps.setInt(7, lessee.getLid());
            int i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, ps);
        }
    }

}
