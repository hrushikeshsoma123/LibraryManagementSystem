package model;

import observer.Observer;

import java.util.ArrayList;
import java.util.List;
public abstract class Book {
    protected String title;
    protected String author;
    protected String isbn;
    protected int publicationYear;
    protected boolean isAvailable = true;

    private List<Observer> observers = new ArrayList<>();

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = year;
    }

    public abstract boolean canBeBorrowed();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update("model.Book available: " + title);
        }
    }

    // getters/setters
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) {
        this.isAvailable = available;
        if (available) notifyObservers();
    }
}