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
        prst.setString(2, post.getTitle());
        prst.setString(3, post.getInfo());
        prst.setString(4, post.getPicture());
        prst.setString(5, post.getDate());
//        prst.setDate(5,new java.sql.Date(post.setDate());
        prst.setInt(6, post.getUser().getId());
        prst.setInt(7, post.getVisible());
        System.out.print("date succuss");
        boolean result = prst.executeUpdate() > 0;
        return result;

    }

    public static boolean deletePost(int postId,int userId) throws Exception {
        try {
            conn = JDBCutil.getCon();
            Statement statement = conn.createStatement();
            statement.setQueryTimeout(30);
            String deletePost = "DELETE FROM post WHERE id='"+postId+"'and User_id='"+userId+"'";
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
    public static final List<Post> getAllPosts(int currentUserId) throws Exception{
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

             while (results.next()) {
                 Post post = new Post();
                 User user = new User();
                 String postId = results.getString("ID");
                 int isLike = LikeDao.isLike(currentUserId, postId);
                 int isCollect = CollectDao.isCollect(currentUserId, postId);
                 post.setIsCollect(isCollect);
                 post.setIsLikes(isLike);
                 user.setScreenname(results.getString("user_screenname"));
                 user.setProfile_picture(results.getString("user_profile_picture"));
                 user.setPrivacy(Integer.valueOf(results.getString("user_privacy")));
                 post.setUser(user);
                 post.setId(results.getInt("ID"));
                 post.setCategory(results.getInt("Category"));
                 post.setTitle(results.getString("Title"));
                 post.setInfo(results.getString("Info"));
                 post.setPicture(results.getString("Picture"));
                 post.setDate(results.getString("Date"));
                 post.setVisible(results.getInt("Visible"));
                 post.setLikesCount(LikeDao.queryLikeCount(post.getId()));
                 postList.add(post);

//                System.out.println(post.getTitle());
             }
             statement.close();
         } catch (SQLException e) {
             System.err.println(e.getMessage());
         }
        return postList;
    }


}
