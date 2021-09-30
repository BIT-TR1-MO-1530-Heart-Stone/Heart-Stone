package dao;

import model.LikePost;
import util.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class LikeDao {
    static Connection conn = null;
    static PreparedStatement prst = null;

    public static boolean like(LikePost likePost) throws Exception {
        try {
            conn = JDBCutil.getCon();
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
            String deletePost = "insert into like (Like_Time, User_id, Post_id) values(?,?,?)";
            prst.setString(1, likePost.getLike_date());
            prst.setInt(2, likePost.getUser_id());
            prst.setInt(3, likePost.getPost_id());
            int result = statement.executeUpdate(deletePost);
            statement.close();
            return result > 0 ? true : false;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }


    public static boolean unlike(LikePost likePost) throws Exception {
        try {
            conn = JDBCutil.getCon();
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
            String deletePost = "DELETE FROM `like` WHERE User_id=? and Post_id=?";
            prst.setInt(1, likePost.getUser_id());
            prst.setInt(2, likePost.getPost_id());
            int result = statement.executeUpdate(deletePost);
            statement.close();
            return result > 0 ? true : false;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

}
