package dao;

import model.LikePost;
import util.JDBCutil;

import java.sql.*;

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

    // Whether the user likes this post or not 0 - No 1 - yes
    public static int isLike(int userId, String postId) {
        int res = 0;
        try {
            try {
                conn = JDBCutil.getCon();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT T.ID  FROM `like` T WHERE T.User_id = '" + userId + "'  AND T.Post_id = '"
                    + postId + "'";
            System.out.println(query);
            ResultSet results = statement.executeQuery(query);
            if (results.next()) {
                res = 1;
            }
            statement.close();
        } catch (SQLException e) {
            return res;
        }
        return res;
    }

    // Query the number of likes of microblog
    public static int queryLikeCount(int postId) {
        int res = 0;
        try {
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT COUNT(*) LIKE_COUNT FROM `like` WHERE Post_id = '" + postId + "'";
            System.out.println(query);
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                res = Integer.parseInt(results.getString("like_count"));
            }
            statement.close();
        } catch (SQLException e) {
            return res;
        }
        return res;
    }

}
