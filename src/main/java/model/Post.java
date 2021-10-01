package model;

/**
 * @author Xinyu Chen, 2021. email: s3798356@student.rmit.edu.au
 */
public class Post {
    private int Id;
    private int Category;
    private String Info;
    private String Title;
    private String Picture;
    private String Date;
    private User user;
    private int Visible;
    private int likes;

    public Post() {
    }

    public Post(int Category, String Title, String Info, String Picture, String Date, User user, int Visible) {
        this.Category = Category;
        this.Info = Info;
        this.Title = Title;
        this.Picture = Picture;
        this.Date = Date;
        this.user = user;
        this.Visible = Visible;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
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

    public void setDate(String Date) {
        this.Date = Date;
        System.out.print(1111);
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

    public int getVisible() {
        return Visible;
    }

    public void setVisible(int visible) {
        Visible = visible;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
