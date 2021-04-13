package com.zzx.dao.impl;

import com.zzx.dao.HouseDao;
import com.zzx.model.House;
import com.zzx.util.DBUtil;
import com.zzx.util.PageUtil;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HouseDaoImpl implements HouseDao {
    public ArrayList<House> SelectByAddress(String address){
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<House> list = new ArrayList<>();
        String sql = "select * from house where haddress like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,"%"+address+"%");
            rs = ps.executeQuery();
            while (rs.next()){
                House house = new House();
                house.setHid(rs.getInt("hid"));
                house.setHaddress(rs.getString("haddress"));
                house.setHfloor(rs.getString("hfloor"));
                house.setHroomNum(rs.getInt("hroomNum"));
                house.setHarea(rs.getString("harea"));
                house.setHdir(rs.getString("hdir"));
                house.setHdeco(rs.getInt("hdeco"));
                house.setHair(rs.getInt("hair"));
                house.setHprice(rs.getDouble("hprice"));
                house.setHrentStatus(rs.getInt("hrentStatus"));
                house.setHimage(rs.getString("simage"));
                house.setHaddTime(rs.getDate("haddTime"));
                house.setHupdateTime(rs.getDate("hupdateTime"));
                list.add(house);
            }
            System.out.println("郑子轩的日志:模糊查询的到的数据是 : "+list);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return list;
    }


    /**
     * 这里是查询全部
     * @param pageUtil
     * @param keywordMap
     * @return
     */
    @Override
    public List<House> findAll(PageUtil pageUtil, HashMap<String, String> keywordMap) {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<House> list = new ArrayList<>();
        String sql = "select hid,haddress,hfloor,hroomNum,harea,hdir,hdeco,hair,hprice,hrentStatus,simage,haddTime,hupdateTime from house " +
                " where haddress like concat(\"%\",?,\"%\") limit ?,?";
        try {
            String address = keywordMap.get("address");
            ps = con.prepareStatement(sql);
            ps.setString(1,address == null ? "": address);
            ps.setInt(2,pageUtil.getStart());
            ps.setInt(3,pageUtil.getEnd());
            rs = ps.executeQuery();
            while (rs.next()){
                House house = new House();
                house.setHid(rs.getInt("hid"));
                house.setHaddress(rs.getString("haddress"));
                house.setHfloor(rs.getString("hfloor"));
                house.setHroomNum(rs.getInt("hroomNum"));
                house.setHarea(rs.getString("harea"));
                house.setHdir(rs.getString("hdir"));
                house.setHdeco(rs.getInt("hdeco"));
                house.setHair(rs.getInt("hair"));
                house.setHprice(rs.getDouble("hprice"));
                house.setHrentStatus(rs.getInt("hrentStatus"));
                house.setHimage(rs.getString("simage"));
                house.setHaddTime(rs.getDate("haddTime"));
                house.setHupdateTime(rs.getDate("hupdateTime"));
                list.add(house);
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
    @Override
    public int count(HashMap<String, String> keywordMap) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select count(*) total from house " +
                "where haddress like concat(\"%\",?,\"%\")";
        int total = 0;
        String haddress = keywordMap.get("haddress");
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,haddress == null ? "":haddress );
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
     * 这里是house表的添加功能
     * @param house
     */
    public void AddOne(House house){
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("insert into house(haddress,hfloor,hroomNum,harea,hdir,hdeco,hair,hprice,hrentStatus,simage,haddTime,hupdateTime) values(?,?,?,?,?,?,?,?,?,?,?,?) ");
            ps.setString(1,house.getHaddress());
            ps.setString(2,house.getHfloor());
            ps.setInt(3,house.getHroomNum());
            ps.setString(4,house.getHarea());
            ps.setString(5,house.getHdir());
            ps.setInt(6,house.getHdeco());
            ps.setInt(7,house.getHair());
            ps.setDouble(8,house.getHprice());
            ps.setInt(9,house.getHrentStatus());
            ps.setString(10,house.getHimage());
            ps.setDate(11,new java.sql.Date(house.getHaddTime().getTime()));
            ps.setDate(12,new java.sql.Date(house.getHupdateTime().getTime()));
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(con,ps);
        }
    }

    /**
     * 这里是house表的删除功能
     * @param id
     */
    public void DeleteOne(int id){
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("delete from house where hid = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(con,ps);
        }
    }

    /**
     * 更新前查询房屋信息
     * @param hid
     * @return
     */
    public House findHouseById(int hid) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        House house = null;
        try {
            ps = conn.prepareStatement("select * from house where hid = ?");
            ps.setInt(1,hid);
            rs = ps.executeQuery();
            while (rs.next()) {
                house = new House();
                house.setHid(rs.getInt("hid"));
                house.setHaddress(rs.getString("haddress"));
                house.setHfloor(rs.getString("hfloor"));
                house.setHroomNum(rs.getInt("hroomNum"));
                house.setHarea(rs.getString("harea"));
                house.setHdir(rs.getString("hdir"));
                house.setHdeco(rs.getInt("hdeco"));
                house.setHair(rs.getInt("hair"));
                house.setHprice(rs.getDouble("hprice"));
                house.setHrentStatus(rs.getInt("hrentStatus"));
                house.setHimage(rs.getString("simage"));
                house.setHaddTime(rs.getDate("haddTime"));
                house.setHupdateTime(rs.getDate("hupdateTime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps,rs);
        }
        return house;
    }

    /**
     * 更新房屋信息
     * @param house
     */
    public void findUpdateHouseById(House house) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update house set haddress=?,hfloor=?,hroomNum=?,harea=?,hdir=?,hdeco=?,hair=?,hprice=?,hrentStatus=?,simage=?,haddTime=?,hupdateTime=? where hid = ?");
            ps.setString(1,house.getHaddress());
            //ps.setString(1,house.getHaddress());
            ps.setString(2,house.getHfloor());
            ps.setInt(3,house.getHroomNum());
            ps.setString(4,house.getHarea());
            ps.setString(5,house.getHdir());
            ps.setInt(6,house.getHdeco());
            ps.setInt(7,house.getHair());
            ps.setDouble(8,house.getHprice());
            ps.setInt(9,house.getHrentStatus());
            ps.setString(10,house.getHimage());
            ps.setDate(11,new java.sql.Date(house.getHaddTime().getTime()));
            ps.setDate(12,new java.sql.Date(house.getHupdateTime().getTime()));
            ps.setInt(13,house.getHid());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps);
        }
    }





}
