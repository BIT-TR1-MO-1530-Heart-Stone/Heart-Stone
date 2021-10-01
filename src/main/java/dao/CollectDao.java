package dao;

import model.Collect;
import model.LikePost;
import util.JDBCutil;

import java.sql.*;

public class CollectDao {
    static Connection conn = null;
    static PreparedStatement prst = null;

    public static boolean collect(Collect collect) throws Exception {
        try {
            conn = JDBCutil.getCon();
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
            String deletePost = "insert into collection (Collection_date, User_id, Post_id) values(?,?,?)";
            prst.setString(1, collect.getcollect_date());
            prst.setInt(2, collect.getUser_id());
            prst.setInt(3, collect.getPost_id());
            int result = statement.executeUpdate(deletePost);
            statement.close();
            return result > 0 ? true : false;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }


    public static boolean uncollect(Collect collect) throws Exception {
        try {
            conn = JDBCutil.getCon();
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
            String deleteCollect = "DELETE FROM `collection` WHERE User_id=? and Post_id=?";
            prst.setInt(1, collect.getUser_id());
            prst.setInt(2, collect.getPost_id());
            int result = statement.executeUpdate(deleteCollect);
            statement.close();
            return result > 0 ? true : false;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    // Whether the user collect this post or not 0 - No 1 - yes
    public static int isCollect(int userId, String postId) {
        int res = 0;
        try {
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT T.ID  FROM `collection` T WHERE T.User_id = '" + userId + "'  AND T.Post_id = '"
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




}
