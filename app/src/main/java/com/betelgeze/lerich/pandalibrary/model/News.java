package com.betelgeze.lerich.pandalibrary.model;

import android.net.Uri;


public class News {
    private String title, dateNews, url, author, authorNews, description;
    private Uri imageUri;
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
            Uri imageUri){
        this.title = title;
        this.dateNews = dateNews;
        this.url = url;
        this.authorNews = authorNews;
        this.author = author;
        this.description = description;
        this.imageUri = imageUri;
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

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }
}
