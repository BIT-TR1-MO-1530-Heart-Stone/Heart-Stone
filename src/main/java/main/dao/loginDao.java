package main.dao;

import main.model.User;
import main.util.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
public class loginDao {
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
}
