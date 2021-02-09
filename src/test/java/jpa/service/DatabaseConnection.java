package jpa.service;

import java.sql.*;

public class DatabaseConnection {
	public static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/SMSCHARLOTTE?serverTimezone=UTC";
	public static final String DBUSER = "root";
	public static final String DBPASSWORD = "12345678";
	private Connection conn = null;

	public DatabaseConnection() {
		try {
			Class.forName(DBDRIVER);
			try {
				this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return this.conn;
	}

	// æ•°æ�®åº“é“¾æŽ¥å…³é—­
	public void close() {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
