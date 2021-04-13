package com.zzx.dao.impl;

import com.zzx.dao.RentDao;
import com.zzx.model.Rent;
import com.zzx.util.DBUtil;
import com.zzx.util.PageUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RentDaoImpl implements RentDao {
    /**
     * 这里是查询全部
     * @param pageUtil
     * @return
     */
    public ArrayList<Rent> SelectAll(PageUtil pageUtil){
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Rent> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from rent");

        sql.append(" limit "+pageUtil.getStart()+","+pageUtil.getEnd()+"");
        try {
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()){
                Rent rent = new Rent();
                rent.setRid(rs.getInt("rid"));
                rent.setRhid(rs.getInt("rhid"));
                rent.setRlid(rs.getInt("rlid"));
                rent.setRprice(rs.getDouble("rprice"));
                rent.setRpayTime(rs.getDate("rpayTime"));
                list.add(rent);
            }
            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return list;
    }

    /**
     * 这里是rent表的添加功能
     * @param rent
     */
    public void AddOne(Rent rent){
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("insert into rent(rhid,rlid,rprice,rpayTime) values(?,?,?,?) ");
            ps.setInt(1,rent.getRhid());
            ps.setInt(2,rent.getRlid());
            ps.setDouble(3,rent.getRprice());
            ps.setDate(4,new java.sql.Date(rent.getRpayTime().getTime()));
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(con,ps);
        }
    }

    public void DeleteOne(int id){
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("delete from rent where rid=?");
            ps.setInt(1,id);
            int i = ps.executeUpdate();
            System.out.println("郑子轩的日志:deleteOne所影响的行数是"+i+"条数据");
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
    public Rent findRentById(int id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Rent rent = null;
        try {
            ps = conn.prepareStatement("select * from rent where rid=?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                rent = new Rent();
                rent.setRid(rs.getInt("rid"));
                rent.setRhid(rs.getInt("rhid"));
                rent.setRlid(rs.getInt("rlid"));
                rent.setRprice(rs.getDouble("rprice"));
                rent.setRpayTime(rs.getDate("rpayTime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps,rs);
        }
        return rent;
    }

    /**
     * 更新数据
     * @param rent
     */
    public void findUpdateById(Rent rent) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update rent set rhid=?,rlid=?,rprice=?,rpayTime=?  where rid=?");
            ps.setInt(1, rent.getRhid());
            ps.setInt(2, rent.getRlid());
            ps.setDouble(3, rent.getRprice());
            ps.setDate(4,new java.sql.Date(rent.getRpayTime().getTime()));
            ps.setInt(5, rent.getRid());
            int i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, ps);
        }
    }

    public List<Rent> findAll(PageUtil pageUtil, HashMap<String, String> map) {
        return null;

    }

    public int count(HashMap<String, String> map) {
        return 1;
    }
}
