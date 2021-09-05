package dao;

import model.Post;
import model.User;
import util.JDBCutil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
    static Connection conn = null;
    static PreparedStatement prst = null;

    private Post post = new Post();

    public static boolean create(Post post) throws Exception {
        conn = JDBCutil.getCon(); // ��ȡ���ݿ�����

        String createPost = "insert into post(Category, Title, Info, Picture, Date, UserID) values(?,?,?,?,?,?)"; // ��дsql���

        prst = conn.prepareStatement(createPost); // ��sql������Ԥ����

        prst.setInt(1, post.getCategory());
        prst.setString(2, post.getInfo());
        prst.setString(3, post.getTitle());
        prst.setString(4, post.getPicture());
        prst.setString(5, post.getDate());
        prst.setInt(6, post.getUserID());
        boolean result = prst.executeUpdate() > 0; // ִ��sql���
        return result;

    }

    public static boolean delete(int id) throws Exception {
        try {
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
            String deletePost = "DELETE FROM post WHERE id=?";
            System.out.println(deletePost);
            int result = statement.executeUpdate(deletePost);
            statement.close();
            return result > 0 ? true : false;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }



    public static final List<Post> getAllPosts(){
         ArrayList<Post> postList = new ArrayList<>();
         try {
             Statement statement = conn.createStatement();
             statement.setQueryTimeout(30);
             String query = "SELECT ID,\n" +
                     "       Category,\n" +
                     "       Title,\n" +
                     "       Info,\n" +
                     "       Picture,\n" +
                     "       Date,\n" +
                     "       User_ID"+
                     "  FROM post";
             System.out.println(query);
             ResultSet results = statement.executeQuery(query);
             Post post;
             while (results.next()) {
                 post = new Post();
                 post.setId(results.getInt("Post_ID"));
                 post.setCategory(results.getInt("Post_Category"));
                 post.setTitle(results.getString("Post_Title"));
                 post.setInfo(results.getString("Post_Info"));
                 post.setPicture(results.getString("Post_Picture"));
                 post.setDate(results.getString("Post_Date"));
                 post.setUserID(results.getInt("User_ID"));
                 postList.add(post);
             }
             statement.close();
         } catch (SQLException e) {
             System.err.println(e.getMessage());
         }
        return postList;
    }


}
