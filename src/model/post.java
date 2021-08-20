package model;

import javax.swing.text.AbstractDocument;

public class post {
    private int id;
    private int Category;
    private char Date;
    private char Introduction;
    private char Content;
    private char Picture;

    public post() {
    }

    public post(int Category, char Date, char Introduction, char Content, char Picture) {
        this.Category = Category;
        this.Date = Date;
        this.Introduction = Introduction;
        this.Content = Content;
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

    public char getDate() {
        return Date;
    }

    public char getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(char introduction) {
        Introduction = introduction;
    }

    public char getContent() {
        return Content;
    }

    public void setContent(char content) {
        Content = content;
    }

    public char getPicture() {
        return Picture;
    }

    public void setPicture(char picture) {
        Picture = picture;
    }
}
