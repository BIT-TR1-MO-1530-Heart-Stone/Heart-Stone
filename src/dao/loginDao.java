package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
import model.User;
 
import util.JDBCutil;
 
public class loginDao {
	static Connection conn = null;
	static PreparedStatement prst = null;
	static ResultSet rs = null;
 
	private User user = new User();
 
	// �û���¼
	public static int login(User user) throws Exception {
 
		int result = -1;
		conn = JDBCutil.getCon(); // ��ȡһ�����ݿ�����
 
		String sql = "select * from t1_user where username=? and password=?"; // ��дsql���
 
		prst = conn.prepareStatement(sql); // ��ssql������Ԥ����
 
		prst.setString(1, user.getUsername());
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
 
		String sql = "insert into t1_user(username,password,email,gender,country,first_name,last_name) values(?,?,?,?,?,?,?)"; // ��дsql���
 
		prst = conn.prepareStatement(sql); // ��sql������Ԥ����
 
		prst.setString(1, user.getUsername());
		prst.setString(2, user.getPassword());
		prst.setString(3, user.getEmail());
		prst.setString(4, user.getGender());
		prst.setString(5, user.getCountry());
		prst.setString(6, user.getFirst_name());
		prst.setString(7, user.getLast_name());
		boolean result = prst.executeUpdate() > 0; // ִ��sql���
		return result;
	}
}
