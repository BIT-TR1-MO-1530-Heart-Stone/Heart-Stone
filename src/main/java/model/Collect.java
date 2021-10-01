package model;

/**@author Xinyu Chen, 2021. email: s3798356@student.rmit.edu.au**/

public class Collect {

    private int collect_Id;
    private String collect_date;
    private int user_id;
    private int post_id;

    public Collect(String like_date, int user_id, int post_id) {
        this.collect_Id = collect_Id;
        collect_date = collect_date;
        this.user_id = user_id;
        this.post_id = post_id;
    }

    public void collectPost() {
    }

    public int getId() {
        return collect_Id;
    }

    public String getcollect_date() {
        return collect_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getPost_id() {
        return post_id;
    }

}