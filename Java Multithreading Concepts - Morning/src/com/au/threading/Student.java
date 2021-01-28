package com.au.threading;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private int id;
    private String name;
    private List<Book> cart;

    public Student(int id, String name) {
        super();
        this.id = id;
        this.name = name;
        this.cart = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getCartDatails() {
        return cart;
    }

    public void addInCart(Book book) {
        this.cart.add(book);
    }

    public void outOfCart(Book book) {
        this.cart.remove(book);
    }
}
