package model;

/**@author Xinyu Chen, 2021. email: s3798356@student.rmit.edu.au**/

public class LikePost {

    private int Id;
    private String Like_date;
    private int user_id;
    private int post_id;

    public LikePost(String like_date, int user_id, int post_id) {
        this.Id = Id;
        Like_date = like_date;
        this.user_id = user_id;
        this.post_id = post_id;
    }

    public LikePost() {
    }

    public int getId() {
        return Id;
    }

    public String getLike_date() {
        return Like_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getPost_id() {
        return post_id;
    }

}
