package dao;

import model.User;
import util.JDBCutil;

import java.sql.*;

public class userDao {
	static Connection conn = null;
	static PreparedStatement prst = null;
	static ResultSet rs = null;
 
	private User user = new User();
 
	// �û���¼
	public static int login(User user) throws Exception {
 
		int result = -1;
		conn = JDBCutil.getCon(); // ��ȡһ�����ݿ�����
 
		String sql = "select * from user where Email=? and password=?"; // ��дsql���
 
		prst = conn.prepareStatement(sql); // ��ssql������Ԥ����
 
		prst.setString(1, user.getEmail());
		prst.setString(2, user.getPassword());
 
		rs = prst.executeQuery(); // ִ��sql��䣬 �����ؽ����
 
		if (rs.next())
			result = rs.getInt(1);
 
		if (result > 0)
			return 1;
 
		else
			return 0;
 
	}
 
	// �û�ע��
	public static boolean register(User user) throws Exception {
 
		conn = JDBCutil.getCon(); // ��ȡ���ݿ�����
 
		String sql = "insert into user(Email,password,Fullname,Screenname,phone_number,info,Gender) values(?,?,?,?,?,?,?)"; // ��дsql���
 
		prst = conn.prepareStatement(sql); // ��sql������Ԥ����
 
		prst.setString(1, user.getEmail());
		prst.setString(2, user.getPassword());
		prst.setString(3, user.getFullname());
		prst.setString(4, user.getScreenname());
		prst.setString(5, user.getPhone_number());
		prst.setString(6, user.getInfo());
		prst.setInt(7, user.getGender());
		boolean result = prst.executeUpdate() > 0; // ִ��sql���
		return result;
	}
	 // Delete account
	 public static boolean deleteAccount(String email, String password)throws Exception  {
	     try {
	         Statement statement = conn.createStatement();
	         statement.setQueryTimeout(30);
	         String query = "DELETE FROM user T WHERE T.email = '" + email + "'  AND T.Password = '"
	                 + password + "'";
	         System.out.println(query);
	         int result = statement.executeUpdate(query);
	         statement.close();
	         return result > 0 ? true : false;
	     } catch (SQLException e) {
	         System.err.println(e.getMessage());
	         return false;
	     }
	 }

	 // change Password
	 public static boolean changePassword(String email, String password, String new_password) {
	     try {
	         Statement statement = conn.createStatement();
	         statement.setQueryTimeout(30);
	         String query = "UPDATE user T SET T.Password = '" + new_password + "' "
	                 + " WHERE T.Email = '" + email + "' " + " AND T.Password = '" + password + "'";
	         System.out.println(query);
	         int result = statement.executeUpdate(query);
	         statement.close();
	         return result > 0 ? true : false;
	     } catch (SQLException e) {
	         System.err.println(e.getMessage());
	         return false;
	     }
	 }

	 // update personal information
	 public static boolean modifyInfomation(String fullname,String screenname, String gender, String phone_number,String info,
	         String userId) {
	     try {
	         Statement statement = conn.createStatement();
	         statement.setQueryTimeout(30);
	         String query = "UPDATE user T SET T.=Fullname = '"+fullname+"', T.Screenname = '" + screenname + "', T.Gender = '" + gender
	                 + "', T.Phone_number = '" + phone_number + "', T.info = '" + info + "'" + " WHERE T.ID = '"
	                 + userId + "'";
	         System.out.println(query);
	         int result = statement.executeUpdate(query);
	         statement.close();
	         return result > 0 ? true : false;
	     } catch (SQLException e) {
	         System.err.println(e.getMessage());
	         return false;
	     }
	 }

}
