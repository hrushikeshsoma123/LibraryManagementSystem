import factory.BookFactory;
import model.Book;
import model.Patron;
import service.LendingService;
import service.LibraryService;
import strategy.PopularRecommendation;
import strategy.RecommendationService;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        LibraryService library = new LibraryService();
        LendingService lending = new LendingService();

        // Create books using Factory
        Book b1 = BookFactory.createBook("REGULAR", "Human Psychology", "Michal", "122", 2022);
        Book b2 = BookFactory.createBook("REFERENCE", "Psychology", "Martin", "445", 2000);

        library.addBook(b1);
        library.addBook(b2);

        // Create model.Patron
        Patron p1 = new Patron("P1", "Robert");

        // observer.Observer (reservation)
        b1.addObserver(p1);

        // Checkout
        lending.checkoutBook(p1, b1);

        // Return (triggers notification)
        lending.returnBook(p1, b1);

        // Recommendation
        RecommendationService recService =
                new RecommendationService(new PopularRecommendation());

        List<Book> recommendations =
                recService.recommend(p1, new ArrayList<>(Arrays.asList(b1, b2)));

        System.out.println("Recommended Books:");
        recommendations.forEach(b -> System.out.println(b.getTitle()));
    }
}