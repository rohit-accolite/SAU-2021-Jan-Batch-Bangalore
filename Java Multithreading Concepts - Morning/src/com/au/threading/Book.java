package com.au.threading;

public class Book {

    private int id;
    private String name;
    private int ISBN;
    private String currentHolder;
    private boolean underReview;
    private boolean isInCart;
    private boolean isPurchased;

    public Book(int id, String name, int ISBN) {
        super();
        this.id = id;
        this.name = name;
        this.ISBN = ISBN;
        this.currentHolder = "";
        this.underReview = false;
        this.isPurchased = false;
        this.isInCart = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCurrentHolder() {
        return currentHolder;
    }

    public void setCurrentHolder(String currentHolder) {
        this.currentHolder = currentHolder;
    }

    public boolean isUnderReview() {
        return underReview;
    }

    public void setUnderReview(boolean underReview) {
        this.underReview = underReview;
    }

    public boolean isInCart() {
        return isInCart;
    }

    public void setInCart(boolean inCart) {
        isInCart = inCart;
    }

    public boolean isPurchased() {
        return isPurchased;
    }

    public void setPurchased(boolean purchased) {
        isPurchased = purchased;
    }
}
