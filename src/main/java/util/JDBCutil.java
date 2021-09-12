package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class JDBCutil {
 
	private static String url = "jdbc:mysql://localhost:3306/data?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8";
	private static String user = "root";
	private static String password = "root";
//	private static String driver = "com.mysql.jdbc.Driver";
	private static String driver = "com.mysql.cj.jdbc.Driver";
	
	public static Connection getCon() throws Exception {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
	//�ر����ݿ�����
	public static void getClose(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}

}