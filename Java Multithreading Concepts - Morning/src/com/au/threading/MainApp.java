package com.au.threading;

public class MainApp {

    public static void main(String[] args) throws InterruptedException {

        Library library = new Library();

        Thread add0 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    library.addInLibrary(new Book(0, "The Lord of the Rings", 10));
                    library.addInLibrary(new Book(1, "The Count of Monte Cristo", 11));
                    library.addInLibrary(new Book(2, "A Game of Thrones", 12));
                    library.addInLibrary(new Book(3, "To Kill a Mockingbird", 13));
                    library.addInLibrary(new Book(4, "To Kill a Mockingbird", 13));
                    library.addInLibrary(new Book(5, "The Count of Monte Cristo", 11));
                    library.addInLibrary(new Book(6, "The Alchemist", 15));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        add0.start();
        System.out.println();

        Student s1 = new Student(1, "Rohit");
        Student s2 = new Student(2, "Krishna");
        Student s3 = new Student(3, "Manik");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    library.review(s1, library.booksList.get(1));
                    library.review(s1, library.booksList.get(2));
                    library.putBack(s1, library.booksList.get(1));

                    library.addToCart(s1, library.booksList.get(2));
                    library.addToCart(s1, library.booksList.get(0));

                    library.removeFromCart(s1, library.booksList.get(2));
                    library.purchase(s1);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    library.review(s2, library.booksList.get(1));
                    library.review(s2, library.booksList.get(2));
                    library.review(s2, library.booksList.get(0));

                    library.putBack(s2, library.booksList.get(2));

                    library.addToCart(s2, library.booksList.get(5));
                    library.addToCart(s2, library.booksList.get(1));

                    library.purchase(s2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // adding books without affecting other processes
        Thread add1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    library.addInLibrary(new Book(7, "Candide", 16));
                    library.addInLibrary(new Book(8, "The Witcher", 17));
                    library.addInLibrary(new Book(9, "The Witcher", 17));
                    library.addInLibrary(new Book(10, "The Girl with the Dragon Tattoo", 20));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        add1.start();
        System.out.println();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    library.review(s3, library.booksList.get(5));
                    library.review(s3, library.booksList.get(7));
                    library.review(s3, library.booksList.get(9));
                    library.review(s3, library.booksList.get(10));

                    library.putBack(s3, library.booksList.get(7));
                    library.putBack(s3, library.booksList.get(10));

                    library.addToCart(s3, library.booksList.get(10));
                    library.addToCart(s3, library.booksList.get(9));

                    library.purchase(s3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}