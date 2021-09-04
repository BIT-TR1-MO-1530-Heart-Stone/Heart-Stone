package main.dao;

import main.model.Post;
import main.model.User;
import main.util.JDBCutil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
    static Connection conn = null;
    static PreparedStatement prst = null;
    static ResultSet rs = null;

    private Post post = new Post();

    public static boolean create(Post post) throws Exception {
        conn = JDBCutil.getCon(); // ��ȡ���ݿ�����

        String createPost = "insert into post(Category, Title, Info, Picture, Date) values(?,?,?,?,?)"; // ��дsql���

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
        conn = JDBCutil.getCon(); // ��ȡ���ݿ�����

        String deletePost = "DELETE FROM post WHERE id=?"; // ��дsql���

        prst = conn.prepareStatement(deletePost); // ��sql������Ԥ����
        boolean result = prst.executeUpdate() > 0; // sql delete success
        return result;
    }

    public List<Post> getAllPosts() throws Exception {
        ArrayList<Post> postList = new ArrayList<Post>();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("Select * FROM post");
        while (rs.next()) {
            postList.add(mapPost(rs));
        }
        statement.close();
        return postList;

    }

    private Post mapPost(ResultSet rs) throws SQLException {
        Post post = new Post(rs.getInt(2), rs.getString(3), rs.getString(4),
                rs.getString(5), rs.getString(6), rs.getInt(7));
        post.setId(rs.getInt(1));
        return post;
    }


//    public static List<Post> getAllPosts() throws Exception{
//         ArrayList<Post> postList = new ArrayList<Post>();
//         try {
//             Statement statement = conn.createStatement();
//             statement.setQueryTimeout(30);
//             String query = " SELECT U.USER_SCREENNAME,\n" + "           U.USER_PROFILE_PICTURE,\n"
//                     + "           P.POST_ID,\n" + "           P.USER_ID,\n" + "           P.POST_CONTENT,\n"
//                     + "           P.ORIGINAL,\n" + "           P.REPOST_ID,\n"
//                     + "           TO_CHAR(P.POST_DATE, 'yyyy-MM-dd hh24:mi:ss') POST_DATE\n"
//                     + "      FROM post P, user U\n" + "     WHERE P.USER_ID = U.USER_ID\n"
//                     + "     ORDER BY P.POST_DATE";
//             ResultSet results = statement.executeQuery(query);
//             Post post = null;
//             User user = null;
//             while (results.next()) {
//                 post = new Post();
//                 user = new User();
//                 String userId = results.getString("user_id");
//                 String postId = results.getString("post_id");
//                 // Like 0——no 1——yes
//                 int isLike = isLike(userId, postId);
//                 post.setLikes(isLike);
//                 user.setScreenname(results.getString("user_screenname"));
//                 user.setProfile_picture(results.getString("user_profile_picture"));
//                 post.setUser(user);
//                 post.PostId(postId);
//                 post.setUserId(userId);
//                 post.setContent(results.getString("post_content"));
//                 post.setPostDate(results.getString("post_date"));
//                 post.setOriginal(Integer.valueOf(results.getString("original")));
//                 post.setRepostId(Integer.valueOf(results.getString("repost_id")));
//                 post.setCommentCount(queryCommentCount(postId));
//                 post.setLikeCount(queryLikeCount(postId));
//                 postList.add(post);
//             }
//             statement.close();
//         } catch (SQLException e) {
//             System.err.println(e.getMessage());
//         }
//         return postList;
//     }


}
