package service;

import model.Book;
import model.Patron;

public class LendingService {

    public void checkoutBook(Patron patron, Book book) {
        if (!book.canBeBorrowed()) {
            throw new RuntimeException("Cannot borrow reference book");
        }

        if (!book.isAvailable()) {
            throw new RuntimeException("model.Book not available");
        }

        book.setAvailable(false);
        patron.borrowBook(book);

        System.out.println("model.Book issued: " + book.getTitle());
    }

    public void returnBook(Patron patron, Book book) {
        patron.returnBook(book);
        book.setAvailable(true);

        System.out.println("model.Book returned: " + book.getTitle());
    }
}