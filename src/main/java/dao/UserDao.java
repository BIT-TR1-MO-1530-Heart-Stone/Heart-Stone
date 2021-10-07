package dao;

import model.LikePost;
import model.User;
import util.JDBCutil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
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
    public static boolean deleteAccount(String email, String password) throws Exception {
        try {
            conn = JDBCutil.getCon();
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
    public static boolean changePassword(String email, String password, String new_password) throws Exception{
        try {
            conn = JDBCutil.getCon();
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
    public static boolean modifyInfomation(User user) throws Exception{
        try {
            conn = JDBCutil.getCon();
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
            String query = "UPDATE user T SET T.=Fullname = '" + user.getFullname() + "', T.Screenname = '" + user.getScreenname() + "', T.Gender = '" + user.getGender()
                    + "', T.Phone_number = '" + user.getPhone_number()+ "', T.Private = '" + user.getPrivacy() + "', T.info = '" + user.getInfo() + "'" + " WHERE T.ID = '"
                    + user.getId() + "'";
            System.out.println(query);
            int result = statement.executeUpdate(query);
            statement.close();
            return result > 0 ? true : false;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    private static final List<User> getAllUsers() throws Exception{
        ArrayList<User> userList = new ArrayList<>();
        try {
            conn = JDBCutil.getCon();
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT T.ID,\n" +
                    "       T.Password,\n" +
                    "       T.Fullname,\n" +
                    "       T.Screenname,\n" +
                    "       T.Gender,\n" +
                    "       T.Phone_number,\n" +
                    "       T.Email,\n" +
                    "       T.info,\n" +
                    "       T.private" +
                    "  FROM user T";
            ResultSet results = statement.executeQuery(query);
            User user;
            while (results.next()) {
                user = new User();
                user.setId(results.getInt("ID"));
                user.setScreenname(results.getString("Screenname"));
                user.setFullname(results.getString("Fullname"));
                user.setGender(results.getInt("Gender"));
                user.setPassword(results.getString("Password"));
                user.setPhone_number(results.getString("Phone_number"));
                user.setEmail(results.getString("Email"));
                user.setInfo(results.getString("info"));
                user.setPrivacy(results.getInt("private"));
                userList.add(user);
            }
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return userList;
    }

    public static User getUserByUserEmailAndPassword(String email, String password) throws Exception{
        return getAllUsers().stream().filter(user -> (user.getEmail().equals(email) && user.getPassword().equals(password))
        ).findFirst().orElse(null);
    }
//    private static User getUsersByEmail(String email) throws Exception{
//        try {
//            conn = JDBCutil.getCon();
//            Statement statement = conn.createStatement();
//            statement.setQueryTimeout(30);
//            String query= "SELECT* FROM `user` WHERE Email=?";
//            prst.setString(1, email);
//            ResultSet results = statement.executeQuery(query);
//            User user = new User();
//                user.setId(results.getInt("ID"));
//                user.setScreenname(results.getString("Screenname"));
//                user.setFullname(results.getString("Fullname"));
//                user.setGender(results.getInt("Gender"));
//                user.setPassword(results.getString("Password"));
//                user.setPhone_number(results.getString("Phone_number"));
//                user.setEmail(results.getString("Email"));
//                user.setInfo(results.getString("info"));
//                user.setPrivacy(results.getInt("Private"));
//            statement.close();
//            return user;
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//        return null;
//    }
public static User getUserByUserEmail(String email) throws Exception{
    return getAllUsers().stream().filter(user -> (user.getEmail().equals(email))
    ).findFirst().orElse(null);
}
    static User getUsersByID(int ID) throws Exception{
        try {
            conn = JDBCutil.getCon();
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT* FROM `user` WHERE ID= '" + ID + "'";
            ResultSet results = statement.executeQuery(query);
            User user = new User();
            user.setId(results.getInt("ID"));
            user.setScreenname(results.getString("Screenname"));
            user.setFullname(results.getString("Fullname"));
            user.setGender(results.getInt("Gender"));
            user.setPassword(results.getString("Password"));
            user.setPhone_number(results.getString("Phone_number"));
            user.setEmail(results.getString("Email"));
            user.setInfo(results.getString("info"));
            user.setPrivacy(results.getInt("Private"));

            statement.close();
            return user;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
