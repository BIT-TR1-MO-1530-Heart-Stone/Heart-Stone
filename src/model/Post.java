package model;

public class Post {
    private int id;
    private int Category;
    private String info;
    private String Title;
    private String Picture;
    private String Date;

    public Post() {
    }

    public Post(int Category, String info, String Title, String Picture, String Date) {
        this.Category = Category;
        this.info = info;
        this.Title = Title;
        this.Picture = Picture;
        this.Date = Date;
    }


    public int getId() {
        return id;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int category) {
        Category = category;
    }

    public String getDate() {
        return Date;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
