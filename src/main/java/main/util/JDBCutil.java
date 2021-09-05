package main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 

public  class JDBCutil {
 
	private static String url = "jdbc:mysql://localhost:3306/db_jsp?useUnicode=true&characterEncoding=utf8";
	private static String user = "root";
	private static String password = "396205";
	private static String driver = "com.mysql.cj.jdbc.Driver";
    
	
	public static Connection getCon() throws Exception {
		Class.forName(driver); // �������ݿ�����
		Connection con = DriverManager.getConnection(url, user, password); // ��ȡ���ݿ�����
		return con;
	}
	
	//�ر����ݿ�����
	public static void getClose(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
 
	}

}