package com.zzx.dao.impl;

import com.zzx.dao.ContractDao;
import com.zzx.model.Contract;
import com.zzx.model.House;
import com.zzx.model.Lessee;
import com.zzx.util.DBUtil;
import com.zzx.util.PageUtil;

import java.awt.dnd.DnDConstants;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContractDaoImpl implements ContractDao {
    /**
     * 这里是查询全部
     *
     * @param pageUtil
     * @return
     */
    public ArrayList<Contract> SelectAll(PageUtil pageUtil) {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Contract> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from contract");

        sql.append(" limit " + pageUtil.getStart() + "," + pageUtil.getEnd() + "");
        try {
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Contract act = new Contract();
                act.setCid(rs.getInt("cid"));
                act.setCnum(rs.getString("cnum"));
                act.setChid(rs.getInt("chid"));
                act.setClid(rs.getInt("clid"));
                act.setCtime(rs.getDate("ctime"));
                act.setCstartTime(rs.getDate("csartTime"));
                act.setCendTime(rs.getDate("cendTime"));
                act.setCtotalMoney(rs.getString("ctotalMoney"));
                act.setCpayType(rs.getInt("cpayType"));
                list.add(act);
            }

            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps, rs);
        }
        return list;
    }

    //这里是获取数据条数的
    public int count(String keyword) {
        Connection con = DBUtil.getConnection();
        int total = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            StringBuilder ssql = new StringBuilder("select count(*) as total from contract");
            ps = con.prepareStatement(ssql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps, rs);
        }
        return total;
    }

    /**
     * 添加
     *
     * @param act
     */
    public void AddOne(Contract act) {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("insert into contract(cnum,chid,clid,ctime,csartTime,cendTime,ctotalMoney,cpayType) values(?,?,?,?,?,?,?,?) ");
            ps.setString(1, act.getCnum());
            ps.setInt(2, act.getChid());
            ps.setInt(3, act.getClid());
            ps.setDate(4, new java.sql.Date(act.getCtime().getTime()));
            ps.setDate(5, new java.sql.Date(act.getCstartTime().getTime()));
            ps.setDate(6, new java.sql.Date(act.getCendTime().getTime()));
            ps.setString(7, act.getCtotalMoney());
            ps.setInt(8, act.getCpayType());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps);
        }
    }

    /**
     * 这里是house表的删除功能
     *
     * @param id
     */
    public void DeleteOne(int id) {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("delete from contract where cid = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(con, ps);
        }
    }

    /**
     * 更新前查询数据
     *
     * @param cid
     * @return
     */
    public Contract findContractById(int cid) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Contract contract = null;
        try {
            ps = conn.prepareStatement("select * from contract where cid=?");
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                contract = new Contract();
                contract.setCid(rs.getInt("cid"));
                contract.setCnum(rs.getString("cnum"));
                contract.setChid(rs.getInt("chid"));
                contract.setClid(rs.getInt("clid"));
                contract.setCtime(rs.getDate("ctime"));
                contract.setCstartTime(rs.getDate("csartTime"));
                contract.setCendTime(rs.getDate("cendTime"));
                contract.setCtotalMoney(rs.getString("ctotalMoney"));
                contract.setCpayType(rs.getInt("cpayType"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, ps, rs);
        }
        return contract;
    }

    /**
     * 更新数据
     *
     * @param contract
     */
    public void findUpdateById(Contract contract) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update contract set cnum=?,chid=?,clid=?,ctime=?,csartTime=?,cendTime=?,ctotalMoney=?,cpayType=? where cid=?");
            ps.setString(1, contract.getCnum());
            ps.setInt(2, contract.getChid());
            ps.setInt(3, contract.getClid());
            ps.setDate(4, new java.sql.Date(contract.getCtime().getTime()));
            ps.setDate(5, new java.sql.Date(contract.getCstartTime().getTime()));
            ps.setDate(6, new java.sql.Date(contract.getCendTime().getTime()));
            ps.setString(7, contract.getCtotalMoney());
            ps.setInt(8, contract.getCpayType());
            ps.setInt(9, contract.getCid());
            int i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, ps);
        }

    }

    @Override
    public List<Contract> findAll(PageUtil pageUtil, HashMap<String, String> keywordMap) {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Contract> list = new ArrayList<>();
        String sql ="select c.cid,c.cnum,c.chid,c.clid,c.ctime,c.csartTime,c.cendTime,c.ctotalMoney,c.cpayType,h.haddress,l.lname from contract c , house h , lessee l" +
                " where c.chid = h.hid AND c.clid = l.lid and ctotalMoney between ? and ? " +
                " limit ?,?";
        try {
            String lowPrice = keywordMap.get("lowprice");
            Double low = Double.valueOf("".equals(lowPrice)|| lowPrice == null ?"0":lowPrice);

            String highPrice = keywordMap.get("highprice");
            Double high = Double.valueOf("".equals(highPrice) || highPrice == null ? "0" : highPrice);

            ps = con.prepareStatement(sql);
            System.err.println("Contract中的sql"+ps);

            //设置参数
            ps.setDouble(1,low);
            ps.setDouble(2,high==0?Integer.MAX_VALUE:high);
            ps.setInt(3,pageUtil.getStart());
            ps.setInt(4,pageUtil.getEnd());
            System.out.println("ContractDaoIMpl中的FindAll 2 ps = "+ps);
            rs = ps.executeQuery();
            while (rs.next()){
                Contract contract = new Contract();
                contract.setCid(rs.getInt("cid"));
                contract.setCnum(rs.getString("cnum"));
                contract.setChid(rs.getInt("chid"));
                contract.setClid(rs.getInt("clid"));
                contract.setCtime(rs.getDate("ctime"));
                contract.setCstartTime(rs.getDate("csartTime"));
                contract.setCendTime(rs.getDate("cendTime"));
                contract.setCtotalMoney(rs.getString("ctotalMoney"));
                contract.setCpayType(rs.getInt("cpayType"));
                //获取房屋信息
                House house = new House();
                house.setHaddress(rs.getString("haddress"));
                contract.setHouse(house);
                //获取租户信息
                Lessee lessee = new Lessee();
                lessee.setLname(rs.getString("lname"));
                contract.setLessee(lessee);
                list.add(contract);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    DBUtil.closeAll(con,ps,rs);
    return list;

     }

    @Override
    public int count(HashMap<String, String> keywordMap) {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select count(*) total from contract where ctotalMoney between ? and ?";
        int total = 0;
        String lows = keywordMap.get("lowprice");
        Double low = Double.valueOf("".equals(lows) || lows == null ? "0" : lows);

        String highs = keywordMap.get("highprice");
        Double high = Double.valueOf("".equals(highs) || highs == null ? "0" : highs);
        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1,low);
            ps.setDouble(2,high ==0 ?Integer.MAX_VALUE:high);
            rs = ps.executeQuery();
            if (rs.next()){
                total = rs.getInt("total");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        DBUtil.closeAll(con,ps,rs);
        return total;
    }

}
