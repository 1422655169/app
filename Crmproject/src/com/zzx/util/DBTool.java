package com.zzx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTool {
	public static String username = "root";
	public static String password = "root";
	public static String url = "jdbc:mysql://127.0.0.1:3306/testexcel";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

//	public static void main(String[] args) {
//		DBTool dbt = new DBTool();
//		System.out.print(dbt.getConnection());
//	}

}
