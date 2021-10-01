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
    private int isLikes;
    private int likesCount;
    private int isCollect;

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

    public void setIsLikes(int isLikes) {
        this.isLikes = isLikes;
    }

    public User getUser() {
        return user;
    }
    public int getIsLikes() {
        return isLikes;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(int isCollect) {
        this.isCollect = isCollect;
    }
}
