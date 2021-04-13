package com.zzx.util;

import java.sql.*;

/**
 * @author QiuShiju
 * @date 2021/1/13
 * @desc 数据库工具类
 */
public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/crm";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    // 静态代码块,随着类加载而执行.且其中内容在内存只存在一份
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获得连接对象
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace( );
        }
        return conn;
    }

    /**
     * 关流
     */
    public static void closeAll(Connection conn, Statement s, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace( );
            }
        }
        if (s != null) {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace( );
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace( );
            }
        }
    }
    public static void closeAll(Connection conn, Statement s) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace( );
            }
        }
        if (s != null) {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace( );
            }
        }
    }
}
