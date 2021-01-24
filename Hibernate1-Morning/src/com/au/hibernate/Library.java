package com.au.hibernate;

public class Library {

    private int id;
    private String bookName;
    private String authorName;
    private int publishYear;

    public Library() {
    }

    public Library(String bookName, String authorName, int publishYear) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishYear = publishYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
}
