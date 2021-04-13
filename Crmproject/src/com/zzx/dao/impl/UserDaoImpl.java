package com.zzx.dao.impl;

import com.zzx.dao.UserDao;
import com.zzx.model.Auth;
import com.zzx.model.Role;
import com.zzx.model.User;
import com.zzx.util.C3p0Util;

import com.zzx.util.DBUtil;
import com.zzx.util.PageUtil;;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDaoImpl implements UserDao {
    /**
     * 这里是登录功能
     * @param username
     * @param password
     * @return
     */
    public User Login(String username , String password){
        //Connection conn = DBUtil.getConnection();
        Connection conn = C3p0Util.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            ps = conn.prepareStatement("select * from user where uname = ? and upassword= ?");
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if (rs.next()){
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setUpassword(rs.getString("upassword"));
                user.setUrealname(rs.getString("urealname"));
                user.setUaddTime(rs.getTime("uaddTime"));
                user.setUstatus(rs.getInt("ustatus"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            DBUtil.closeAll(conn,ps,rs);
            C3p0Util.closeAll(rs,ps,conn);
        }
        return user;
    }


    /**
     * 这里是注册功能
     * @param user
     */
    public void SignIn(User user){
        Connection con = DBUtil.getConnection();
        PreparedStatement ps= null;
        try {
            ps = con.prepareStatement("insert into user(uname,upassword,urealname,uaddTime,ustatus) values (?,?,?,?,?)");
            ps.setString(1,user.getUname());
            ps.setString(2,user.getUpassword());
            ps.setString(3,user.getUrealname());
            ps.setDate(4,new java.sql.Date(user.getUaddTime().getTime()));
            ps.setInt(5,user.getUstatus());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(con,ps);
        }
    }

    @Override
    public int count(HashMap<String, String> keywordMap) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select count(*) total from user " +
                "where uname like concat(\"%\",?,\"%\") and " +
                "urealname like concat(\"%\",?,\"%\")";
        int total = 0;
        String usname = keywordMap.get("Uname");
        String rsname = keywordMap.get("rname");
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,usname == null ? "":usname );
            ps.setString(2,rsname == null ? "":rsname );
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
     * 这里是查询全部
     * @param pageUtil
     * @return
     */
    public ArrayList<User> SelectAll(PageUtil pageUtil){
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<>();
        User user = null;
        StringBuilder sql = new StringBuilder("select * from user");

        sql.append(" limit "+pageUtil.getStart()+","+pageUtil.getEnd()+"");
        try {
            ps = con.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while(rs.next()) {
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setUpassword(rs.getString("upassword"));
                user.setUrealname(rs.getString("urealname"));
                user.setUaddTime(rs.getTime("uaddTime"));
                user.setUstatus(rs.getInt("ustatus"));
                list.add(user);
            }
            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(con,ps,rs);
        }
        return list;
    }

    @Override
    public List<User> findRole(List<User> users) {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<>();
        ArrayList<Role> roles = null;
        String sql = "select * from role r ,user_role ur where r.roid = ur.rid and ur.uid= ?";

            try {
                for(User u : users){
                ps = con.prepareStatement(sql);
                ps.setInt(1,u.getUid());
                rs = ps.executeQuery();

                //创建存储角色的集合
                roles = new ArrayList<>();
                while (rs.next()){
                    Role role = new Role();
                    role.setRoid(rs.getInt("roid"));
                    role.setRoname(rs.getString("roname"));
                    role.setRoaddTime(rs.getDate("roaddTime"));
                    roles.add(role);
                }
                //给用户设置角色
                u.setRoles(roles);
                list.add(u);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                DBUtil.closeAll(con,ps,rs);
            }

        return list;
    }

    @Override
    public List<Auth> findUserAuth(User user) {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT DISTINCT(a.aid) from `user` u , user_role ur, role r ,role_auth ra,auth a WHERE " +
                " u.uid = ur.uid and ur.rid = r.roid AND r.roid = ra.rid and ra.aid = a.aid AND u.uid = ?";
        ArrayList<Auth> list = new ArrayList<>();
       try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,user.getUid());
           System.out.println("五表权限的SQL语句为"+sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Auth auth = new Auth();
                auth.setAid(rs.getInt("aid"));
                list.add(auth);
            }
       }catch (Exception e){
           e.printStackTrace();
       }
       DBUtil.closeAll(con,ps,rs);
       return list;
    }

    @Override
    public List<User> findAll(PageUtil pageUtil, HashMap<String, String> keywordMap) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        String sql = "select uid,uname,upassword,urealname,uaddTime,ustatus from user " +
                " where uname like concat(\"%\",?,\"%\") and " +
                " urealname like concat(\"%\",?,\"%\") limit ?,?";
        try {
            String uname = keywordMap.get("Uname");
            String rname = keywordMap.get("rname");

            ps = conn.prepareStatement(sql);
            System.out.println("UserDaoImpl.findAll 1 ps = "+ps );
            // 设置参数
            ps.setString(1,uname == null ? "":uname );
            ps.setString(2,rname == null ? "":rname );
            ps.setInt(3,pageUtil.getStart());
            ps.setInt(4,pageUtil.getEnd());
            System.out.println("UserDaoImpl.findAll 2 ps = "+ps );

            rs = ps.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setUpassword(rs.getString("upassword"));
                user.setUrealname(rs.getString("urealname"));
                user.setUaddTime(rs.getDate("uaddTime"));
                user.setUstatus(rs.getInt("ustatus"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DBUtil.closeAll(conn,ps,rs);
        return users;
    }

    public void findDeleteById(int id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("delete from user where uid =?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps);
        }
    }

    /**
     * 更新数据前查询个人数据
     * @param uid
     * @return
     */
    public User findUpdateById(int uid) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            ps = conn.prepareStatement("select * from user where uid = ?");
            ps.setInt(1,uid);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setUpassword(rs.getString("upassword"));
                user.setUrealname(rs.getString("urealname"));
                user.setUaddTime(new java.sql.Date(rs.getDate("uaddTime").getTime()));
                user.setUstatus(rs.getInt("ustatus"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps,rs);
        }
        return user;
    }

    /**
     * 更新数据
     * @param user
     */
    public void findUpdateByAll(User user) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update user set uname=?,upassword=?,urealname=?,uaddTime=?,ustatus=? where uid = ?");
            ps.setString(1,user.getUname());
            ps.setString(2,user.getUpassword());
            ps.setString(3,user.getUrealname());
            ps.setDate(4,new java.sql.Date(user.getUaddTime().getTime()));
            ps.setInt(5,user.getUstatus());
            ps.setInt(6,user.getUid());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,ps);
        }
    }


}
