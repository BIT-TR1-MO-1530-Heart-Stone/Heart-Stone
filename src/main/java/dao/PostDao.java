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

        String createPost = "insert into post (Category, Title, Info, Picture, Date, User_id, Visible) values(?,?,?,?,?,?,?)"; // ��дsql���

        prst = conn.prepareStatement(createPost); // ��sql������Ԥ����

        prst.setInt(1, post.getCategory());
        prst.setString(2, post.getInfo());
        prst.setString(3, post.getTitle());
        prst.setString(4, post.getPicture());
        prst.setString(5, post.getDate());
//        prst.setDate(5,new java.sql.Date(post.setDate());
        prst.setInt(6, post.getUserID());
        prst.setInt(7, post.getVisible());
        System.out.print("date succuss");
        boolean result = prst.executeUpdate() > 0;
        return result;

    }

    public static boolean delete(int id) throws Exception {
        try {
            conn = JDBCutil.getCon();
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

//    public static final List<Post> PersonalPagePost() throws Exception{
//        ArrayList<Post> personalpostlist = new ArrayList<>();
//        try {
//            conn = JDBCutil.getCon();
//            Statement statement = conn.createStatement();
//            statement.setQueryTimeout(30);
//            String query = "SELECT ID,\n" +
//                    "       Category,\n" +
//                    "       Title,\n" +
//                    "       Info,\n" +
//                    "       Picture,\n" +
//                    "       Date,\n" +
//                    "       User_ID,\n"+
//                    "       Visible"+
//                    "  FROM post WHERE User_id = ?";
//
//            ResultSet results = statement.executeQuery(query);
//            Post post;
//            while (results.next()) {
//                post = new Post();
//                post.setId(results.getInt("ID"));
//                post.setCategory(results.getInt("Category"));
//                post.setTitle(results.getString("Title"));
//                post.setInfo(results.getString("Info"));
//                post.setPicture(results.getString("Picture"));
//                post.setDate(results.getString("Date"));
//                post.setVisible(results.getInt("Visible"));
//                personalpostlist.add(post);
//            }
//            statement.close();
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//        return personalpostlist;
//    }

    public static final List<Post> getAllPosts() throws Exception{
         ArrayList<Post> postList = new ArrayList<>();
         try {
             conn = JDBCutil.getCon();
             Statement statement = conn.createStatement();
             statement.setQueryTimeout(30);
             String query = "SELECT ID,\n" +
                     "       Category,\n" +
                     "       Title,\n" +
                     "       Info,\n" +
                     "       Picture,\n" +
                     "       Date,\n" +
                     "       User_ID,\n"+
                     "       Visible"+
                     "  FROM post";
             ResultSet results = statement.executeQuery(query);
             Post post;
             while (results.next()) {
                 post = new Post();
                 post.setId(results.getInt("ID"));
                 post.setCategory(results.getInt("Category"));
                 post.setTitle(results.getString("Title"));
                 post.setInfo(results.getString("Info"));
                 post.setPicture(results.getString("Picture"));
                 post.setDate(results.getString("Date"));
                 post.setUserID(results.getInt("User_ID"));
                 post.setVisible(results.getInt("Visible"));
                 postList.add(post);
//                 System.out.println(post.getTitle());
             }
             statement.close();
         } catch (SQLException e) {
             System.err.println(e.getMessage());
         }
        return postList;
    }


}
