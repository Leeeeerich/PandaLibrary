package com.betelgeze.lerich.pandalibrary.model;

import android.graphics.Bitmap;
import android.net.Uri;

import java.net.URL;


public class Book {
    private String titleBook, urlBook, author, genre, series, year, pages, languageBook, descriptionBook;
    private Bitmap imageBook;
    //private

    public Book(){

    }

    public Book (
            String titleBook,
            String urlBook,
            String author,
            String genre,
            String series,
            String year, String pages,
            String languageBook,
            String descriptionBook,
            Bitmap imageBook){
        this.titleBook = titleBook;
        this.urlBook = urlBook;
        this.author = author;
        this.genre = genre;
        this.series = series;
        this.year = year;
        this.pages = pages;
        this.languageBook = languageBook;
        this.descriptionBook = descriptionBook;
        this.imageBook = imageBook;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public String getUrlBook() {
        return urlBook;
    }

    public void setUrlBook(String urlBook) {
        this.urlBook = urlBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getLanguageBook() {
        return languageBook;
    }

    public void setLanguageBook(String languageBook) {
        this.languageBook = languageBook;
    }

    public String getDescriptionBook() {
        return descriptionBook;
    }

    public void setDescriptionBook(String descriptionBook) {
        this.descriptionBook = descriptionBook;
    }

    public Bitmap getImageBook() {
        return imageBook;
    }

    public void setImageBook(Bitmap imageBook) {
        this.imageBook = imageBook;
    }
}
