package com.au.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;


public class Library {

    List<Book> booksList = new ArrayList<>();
    private Lock lock = new ReentrantLock();
    private Condition reviewCondition = lock.newCondition();
    private Condition purchaseCondition = lock.newCondition();

    public Library() {
        super();
    }

    public void addInLibrary(Book book) {
        lock.lock();

        try {
            booksList.add(book);
//            System.out.println(Thread.currentThread().getName());
            System.out.println("Book " + book.getName() + " is added");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void review(Student student, Book book) {
        lock.lock();
        try {
            if (book.isPurchased() == false) {
                while (book.isUnderReview())
                    reviewCondition.await();

                for (int i = 0; i < booksList.size(); i++) {
                    if (booksList.get(i).getId() == book.getId()) {
                        booksList.get(i).setUnderReview(true);
                        booksList.get(i).setCurrentHolder(student.getName());
//                        System.out.println(Thread.currentThread().getName());
                        System.out.println("Book " + book.getName() + " is under review of " + student.getName());
                        break;
                    }
                }
            } else {
//                System.out.println(Thread.currentThread().getName());
                System.out.println("Book " + book.getName() + " is not available for " + student.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void putBack(Student student, Book book) {
        lock.lock();
        try {

            for (int i = 0; i < booksList.size(); i++) {
                if (booksList.get(i).getId() == book.getId()) {
                    booksList.get(i).setUnderReview(false);
                    booksList.get(i).setCurrentHolder("");
//                    System.out.println(Thread.currentThread().getName());
                    System.out.println("Book " + book.getName() + " has been put back by " + student.getName());
                    reviewCondition.signalAll();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // to purchase a book you must add it in your cart first
    public void purchase(Student student) throws InterruptedException {
        lock.lock();
        try {
            List<Book> books = student.getCartDatails();

            for(int b = 0; b < books.size(); b++) {
                Book book = books.get(b);
                if (book.isPurchased() == false) {
                    book.setPurchased(true);
//                    System.out.println(Thread.currentThread().getName());
                    System.out.println("Book " + book.getName() + " has been purchased by " + student.getName());
                } else {
//                    System.out.println(Thread.currentThread().getName());
                    System.out.println("Book " + book.getName() + " is not available for " + student.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void addToCart(Student student, Book book) throws InterruptedException{
        lock.lock();
        try {
            while (book.isInCart() && !book.getCurrentHolder().equals(student.getName())) {
                purchaseCondition.await();
            }
            if(book.isPurchased() == false) {
                for(int i = 0 ; i < booksList.size() ; i++ ) {
                    if(booksList.get(i).getId() == book.getId()) {
                        booksList.get(i).setInCart(true);
                        booksList.get(i).setUnderReview(true);
                        booksList.get(i).setCurrentHolder(student.getName());

                        student.addInCart(book);

//                        System.out.println(Thread.currentThread().getName());
                        System.out.println("Book " + book.getName() + " is in cart of " + student.getName());
                        break;
                    }
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        finally {
            lock.unlock();
        }
    }

    public void removeFromCart(Student student, Book book) throws InterruptedException{
        lock.lock();
        try {
            if(book.getCurrentHolder().equals(student.getName())) {
                for(int i = 0 ; i < booksList.size() ; i++ ) {
                    if(booksList.get(i).getId() == book.getId()) {
                        booksList.get(i).setInCart(false);
                        booksList.get(i).setUnderReview(false);
                        booksList.get(i).setCurrentHolder("");

                        student.outOfCart(book);

//                        System.out.println(Thread.currentThread().getName());
                        System.out.println("Book " + book.getName() + " is removed from cart of " + student.getName());
                        purchaseCondition.signalAll();
                        break;
                    }
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        finally {
            lock.unlock();
        }
    }
}