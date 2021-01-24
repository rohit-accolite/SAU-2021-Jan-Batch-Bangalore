package com.au.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class LibraryManager {

    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        }
        catch (Exception e) {
            System.err.println(e);
        }

        LibraryManager libraryManager = new LibraryManager();

        Integer bookId1 = libraryManager.addBook("Lord of the Rings", "J. R. R. Tolkien", 1954);
        System.out.println("Book inserted with ID: " + bookId1.intValue());
        Integer bookId2 = libraryManager.addBook("Harry Potter", "J. K. Rowling", 1997);
        System.out.println("Book inserted with ID: " + bookId2.intValue());
        Integer bookId3 = libraryManager.addBook("The Hobbit", "J. R. R. Tolkien", 1937);
        System.out.println("Book inserted with ID: " + bookId3.intValue());
        Integer bookId4 = libraryManager.addBook("The Witcher", "Andrzej Sapkowski", 1986);
        System.out.println("Book inserted with ID: " + bookId4.intValue());
        Integer bookId5 = libraryManager.addBook("His Dark Materials", "Philip Pullman", 1995);
        System.out.println("Book inserted with ID: " + bookId5.intValue());

//        libraryManager.getBooks();
//        libraryManager.getBookById(4);
//        libraryManager.getBooksCount();
//        libraryManager.updateBookById(5);
//        libraryManager.deleteBookById(5);
    }

    private Integer addBook(String bookName, String authorName, int publishYear) {
        Session session = factory.openSession();
        Transaction transaction = null;
        Integer bookId = null;

        try {
            transaction = session.beginTransaction();
            Library library = new Library(bookName, authorName, publishYear);
            bookId = (Integer) session.save(library);
            transaction.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            if(transaction != null) {
                transaction.rollback();
            }
        }
        finally {
            session.close();
        }

        return bookId;
    }

    private void getBooks() {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            List<Library> books = session.createQuery("FROM Library ").list();
            if(books.size() == 0) System.out.println("No books avialable");
            else for (Library book : books) {
                System.out.print(book.getId()+ " ");
                System.out.print(book.getBookName()+ " ");
                System.out.print(book.getAuthorName()+ " ");
                System.out.print(book.getPublishYear()+ " ");
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            if(transaction != null) transaction.rollback();
        }
        finally {
            session.close();
        }
    }

    private void getBookById(int id) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Library book = session.get(Library.class, id);

            if (book == null) System.out.println("Book not available");
            else System.out.println(book.getId()+" "+book.getBookName()+" "+book.getAuthorName()+" "+book.getPublishYear());

            transaction.commit();
        }catch(Exception e) {
            e.printStackTrace();
            if(transaction !=null)
                transaction.rollback();
        }finally {
            session.close();
        }
    }

    private void getBooksCount() {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            session.getTransaction();
            List<Library> books = session.createQuery("FROM Library ").list();
            System.out.println("Total books: "+ books.size());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    private void updateBookById(int id) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Library book = session.get(Library.class, id);
            book.setBookName("A Brief History of Time");
            book.setAuthorName("Stephen Hawking");
            book.setPublishYear(1988);
            session.update(book);
            transaction.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            if(transaction != null) transaction.rollback();
        }
        finally {
            session.close();
        }
    }

    private void deleteBookById(int id) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Library book = session.get(Library.class, id);
            session.remove(book);
            transaction.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            if(transaction != null) transaction.rollback();
        }
        finally {
            session.close();
        }
    }
}
