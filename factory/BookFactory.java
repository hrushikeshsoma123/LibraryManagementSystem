package factory;

import model.Book;
import model.ReferenceBook;
import model.RegularBook;

public class BookFactory {

    public static Book createBook(String type, String title, String author,
                                  String isbn, int year) {

        switch (type.toUpperCase()) {
            case "REGULAR":
                return new RegularBook(title, author, isbn, year);
            case "REFERENCE":
                return new ReferenceBook(title, author, isbn, year);
            default:
                throw new IllegalArgumentException("Invalid book type");
        }
    }
}