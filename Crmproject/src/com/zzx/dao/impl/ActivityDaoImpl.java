package com.zzx.dao.impl;

import com.zzx.dao.ActivityDao;
import com.zzx.model.Activity;
import com.zzx.util.DBUtil;
import com.zzx.util.PageUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivityDaoImpl implements ActivityDao {
    /**
     *
     * 这里是查询全部
     * @param pageUtil
     * @return
     */
    @Override
    public List<Activity> findAll(PageUtil pageUtil, HashMap<String, String> map) {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Activity> list = new ArrayList<>();
        String sql = "select * from activity where asubject like concat(\"%\",?,\"%\") and aprice between ? and ? limit ?,?";
        try {
            String subject = map.get("subject");
            String lowPrice = map.get("lowprice");
            Double low = Double.valueOf("".equals(lowPrice)|| lowPrice == null ?"0":lowPrice);
            String highPrice = map.get("highprice");
            Double high = Double.valueOf("".equals(highPrice) || highPrice == null ? "0" : highPrice);
            ps = con.prepareStatement(sql);

            // 设置参数
            ps.setString(1,subject == null ? "":subject );
            ps.setDouble(2,low);
            ps.setDouble(3,high==0?Integer.MAX_VALUE:high);
            ps.setInt(4,pageUtil.getStart());
            ps.setInt(5,pageUtil.getEnd());
            rs = ps.executeQuery();
            System.out.println("UserDaoImpl.findAll 2 ps = "+ps );
            while (rs.next()) {
                Activity activity = new Activity();
                activity.setAid(rs.getInt("aid"));
                activity.setAtime(rs.getDate("atime"));
                activity.setAsubject(rs.getString("asubject"));
                activity.setAintr(rs.getString("aintr"));
                activity.setAaddress(rs.getString("aaddress"));
                activity.setAprice(rs.getDouble("aprice"));
                list.add(activity);
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
     * 这里是获取数据条数的
     * @param map
     * @return
     */
    @Override
    public int count(HashMap<String, String> map) {
        Connection con = DBUtil.getConnection();
        int total = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String SQL = "select count(*) total from activity where asubject like concat(\"%\",?,\"%\") and aprice between ? and ?";
            String subject = map.get("subject");
            String lowPrice = map.get("lowprice");
            Double low = Double.valueOf("".equals(lowPrice)|| lowPrice == null ?"0":lowPrice);
            String highPrice = map.get("highprice");
            Double high = Double.valueOf("".equals(highPrice) || highPrice == null ? "0" : highPrice);

            ps = con.prepareStatement(SQL);
            ps.setString(1,subject == null ? "":subject );
            ps.setDouble(2,low);
            ps.setDouble(3,high==0?Integer.MAX_VALUE:high);
            rs = ps.executeQuery();
            if (rs.next()){
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
     * 添加数据
     * @param activity
     */
    public void findActivityByAdd(Activity activity) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("insert into activity (atime,asubject,aintr,aaddress,aprice) values (?,?,?,?,?)");
            ps.setDate(1,new java.sql.Date(activity.getAtime().getTime()));
            ps.setString(2,activity.getAsubject());
            ps.setString(3,activity.getAintr());
            ps.setString(4,activity.getAaddress());
            ps.setDouble(5,activity.getAprice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps);
        }
    }

    /**
     * 删除数据
     * @param aid
     */
    public void findActivityByDelete(int aid) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from activity where aid=?");
            ps.setInt(1,aid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps);
        }
    }

    /**
     * 更新前查询数据
     * @param aid
     * @return
     */
    public Activity findActivityById(int aid) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Activity activity = null;
        try {
            ps = conn.prepareStatement("select * from activity where aid=?");
            ps.setInt(1,aid);
            rs = ps.executeQuery();
            while (rs.next()) {
                activity = new Activity();
                activity.setAid(rs.getInt("aid"));
                activity.setAtime(rs.getDate("atime"));
                activity.setAsubject(rs.getString("asubject"));
                activity.setAintr(rs.getString("aintr"));
                activity.setAaddress(rs.getString("aaddress"));
                activity.setAprice(rs.getDouble("aprice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps,rs);
        }
        return activity;

    }

    /**
     * 更新数据
     * @param activity
     */
    public void findActivityByUpdate(Activity activity) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update activity set atime=?,asubject=?,aintr=?,aaddress=?,aprice=? where aid=?");
            ps.setDate(1,new java.sql.Date(activity.getAtime().getTime()));
            ps.setString(2,activity.getAsubject());
            ps.setString(3,activity.getAintr());
            ps.setString(4,activity.getAaddress());
            ps.setDouble(5,activity.getAprice());
            ps.setInt(6,activity.getAid());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps);
        }
    }


}
