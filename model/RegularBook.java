package model;

public class RegularBook extends Book {
    public RegularBook(String title, String author, String isbn, int year) {
        super(title, author, isbn, year);
    }

    @Override
    public boolean canBeBorrowed() {
        return true;
    }
}