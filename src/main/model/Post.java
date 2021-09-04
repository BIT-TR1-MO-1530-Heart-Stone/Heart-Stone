package main.model;

public class Post {
    private int id;
    private int Category;
    private String Info;
    private String Title;
    private String Picture;
    private String Date;
    private int User_id;

    public Post() {
    }

    public Post(int Category, String Info, String Title, String Picture, String Date,int User_id) {
        this.Category = Category;
        this.Info = Info;
        this.Title = Title;
        this.Picture = Picture;
        this.Date = Date;
        this.User_id = User_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int Category) {
        this.Category = Category;
    }

    public String getDate() {
        return Date;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String Picture) {
        this.Picture = Picture;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getUserID() {
        return User_id;
    }
}
