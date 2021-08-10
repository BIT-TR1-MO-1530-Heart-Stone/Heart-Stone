package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
/**
 *  连接诶数据库的工具类
 * @author Administrator
 *
 */
public  class JDBCutil {
 
	private static String url = "jdbc:mysql://localhost:3306/db_jsp?useUnicode=true&characterEncoding=utf8";
	private static String user = "root";
	private static String password = "396205";
	private static String driver = "com.mysql.jdbc.Driver";
    
	
	public static Connection getCon() throws Exception {
		Class.forName(driver); // 加载数据库驱动
		Connection con = DriverManager.getConnection(url, user, password); // 获取数据库连接
		return con;
	}
	
	//关闭数据库连接
	public static void getClose(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
 
	}

}