package com.zzx.dao;

import com.zzx.model.Contract;
import com.zzx.model.Role;
import com.zzx.util.DBUtil;
import com.zzx.util.PageUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoleDao {

    /**
     * 添加角色信息
     * @param role
     */
    public void findRoleByAdd(Role role) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("insert into role (roname,rodesc,roaddTime) values (?,?,?)");
            ps.setString(1,role.getRoname());
            ps.setString(2,role.getRodesc());
            ps.setDate(3,new java.sql.Date(role.getRoaddTime().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps);
        }
    }

    /**
     * 删除数据
     * @param roid
     */
    public void findRoleByDelete(int roid) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from role where roid=?");
            ps.setInt(1,roid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps);
        }
    }

    /**
     * 更新前查询数据
     * @param roid
     * @return
     */
    public Role findRoleById(int roid) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Role role = null;
        try {
            ps = conn.prepareStatement("select * from role where roid=?");
            ps.setInt(1,roid);
            rs = ps.executeQuery();
            while (rs.next()) {
                role = new Role();
                role.setRoid(rs.getInt("roid"));
                role.setRoname(rs.getString("roname"));
                role.setRodesc(rs.getString("rodesc"));
                role.setRoaddTime(rs.getDate("roaddTime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps,rs);
        }
        return role;
    }

    public void findRoleByUpdate(Role role) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update role set roname=?,rodesc=?,roaddTime=? where roid=?");
            ps.setString(1,role.getRoname());
            ps.setString(2,role.getRodesc());
            ps.setDate(3,new java.sql.Date(role.getRoaddTime().getTime()));
            ps.setInt(4,role.getRoid());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps);
        }
    }

    /**
     * 这里是查询全部
     * @param pageUtil
     * @return
     */
    public ArrayList<Role> SelectAll(PageUtil pageUtil){
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Role> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from role");

        sql.append(" limit "+pageUtil.getStart()+","+pageUtil.getEnd()+"");
        try {
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setRoid(rs.getInt("roid"));
                role.setRoname(rs.getString("roname"));
                //role.setRodesc(rs.getString("rodesc"));
                role.setRoaddTime(rs.getDate("roaddTime"));
                list.add(role);
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
            StringBuilder ssql = new StringBuilder("select count(*) as total from role");
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
}
