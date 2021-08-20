package model;

import javax.swing.text.AbstractDocument;

public class post {
    private int id;
    private int Category;
    private String Date;
    private String info;
    private String Picture;


    public post() {
    }

    public post(int Category, String Date, String info, String Picture) {
        this.Category = Category;
        this.Date = Date;
        this.info = info;
        this.Picture = Picture;
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
}
