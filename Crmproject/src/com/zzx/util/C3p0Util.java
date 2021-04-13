package com.zzx.util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Util {
    //通过标识名来创建相应连接池
    static ComboPooledDataSource dataSource=new ComboPooledDataSource("mysql");
    //从连接池中取用一个连接
    public static Connection getConnection(){
        try {
            // dataSource 数据源
            return dataSource.getConnection();

        } catch (Exception e) {
            System.out.println("数据库连接出错!");
            return null;
        }
    }
    //释放连接回连接池
    public static void closeAll(ResultSet rs,Statement s,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("数据库释放资源 "+rs+" 出错!");
            }
        }
        if(s!=null){
            try {
                s.close();
            } catch (SQLException e) {
                System.out.println("数据库释放资源 "+s+" 出错!");
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("数据库释放资源 "+conn+" 出错!");
            }
        }
    }
}
