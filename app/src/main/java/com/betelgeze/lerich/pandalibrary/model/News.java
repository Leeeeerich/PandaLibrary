package com.betelgeze.lerich.pandalibrary.model;

import android.graphics.Bitmap;
import android.net.Uri;


public class News {
    private String title, dateNews, url, author, authorNews, description;
    private Bitmap image;
    //private

    public News(){

    }

    public News(
            String title,
            String dateNews,
            String url,
            String authorNews,
            String author,
            String description,
            Bitmap image){
        this.title = title;
        this.dateNews = dateNews;
        this.url = url;
        this.authorNews = authorNews;
        this.author = author;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateNews() {
        return dateNews;
    }

    public void setDateNews(String dateNews) {
        this.dateNews = dateNews;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthorNews() {
        return authorNews;
    }

    public void setAuthorNews(String authorNews) {
        this.authorNews = authorNews;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
