package model;

/**@author Xinyu Chen, 2021. email: s3798356@student.rmit.edu.au**/

public class Like {

    private int id;
    private String Like_date;
    private int user_id;
    private int post_id;

    public Like(String like_date, int user_id, int post_id) {
        this.id = id;
        Like_date = like_date;
        this.user_id = user_id;
        this.post_id = post_id;
    }
    public int getId() {
        return id;
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
