package dao;

import model.Post;
import util.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class postDao {
    static Connection conn = null;
    static PreparedStatement prst = null;
    static ResultSet rs = null;

    private Post post = new Post();

    public static boolean create(Post post) throws Exception{
        conn = JDBCutil.getCon(); // ��ȡ���ݿ�����

        String createPost = "insert into post(Category, Title, Info, Picture, Date) values(?,?,?,?,?)"; // ��дsql���

        prst = conn.prepareStatement(createPost); // ��sql������Ԥ����

        prst.setInt(1, post.getCategory());
        prst.setString(2, post.getInfo());
        prst.setString(3, post.getTitle());
        prst.setString(4, post.getPicture());
        prst.setString(5, post.getDate());
        boolean result = prst.executeUpdate() > 0; // ִ��sql���
        return result;

    }

//    public static boolean delete(Post post) throws Exception{
//        conn = JDBCutil.getCon(); // ��ȡ���ݿ�����
//
//        String deletePost = "DELETE FROM calories WHERE id=?"; // ��дsql���
//
//        prst = conn.prepareStatement(deletePost); // ��sql������Ԥ����
//    }



}
