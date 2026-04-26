package model;

public class ReferenceBook extends Book {
    public ReferenceBook(String title, String author, String isbn, int year) {
        super(title, author, isbn, year);
    }

    @Override
    public boolean canBeBorrowed() {
        return false;
    }
}