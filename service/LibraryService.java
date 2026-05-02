package service;

import model.Book;
import model.Patron;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryService {

    private Map<String, Book> books = new HashMap<>();
    private Map<String, Patron> patrons = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    public List<Book> searchByTitle(String title) {
        return books.values().stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String author) {
        return books.values().stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public Book searchByISBN(String isbn) {
        return books.get(isbn);
    }

    public void addPatron(Patron patron) {
        patrons.put(patron.toString(), patron);
    }

    public Patron getPatron(String id) {
        return patrons.get(id);
    }
}