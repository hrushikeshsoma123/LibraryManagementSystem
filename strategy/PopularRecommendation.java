package strategy;

import model.Book;
import model.Patron;

import java.util.List;

public class PopularRecommendation implements RecommendationStrategy {

    @Override
    public List<Book> recommend(Patron patron, List<Book> allBooks) {
        return allBooks.subList(0, Math.min(3, allBooks.size()));
    }
}
