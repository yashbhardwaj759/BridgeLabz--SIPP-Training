import java.util.*;
import java.util.stream.*;

class Book {
    String title;
    int price;

    Book(String title, int price) {
        this.title = title;
        this.price = price;
    }
}

public class BookSorting {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Book A", 20),
                new Book("Book B", 35),
                new Book("Book C", 15));

        List<String> sortedTitles = books.stream()
                .sorted(Comparator.comparingInt((Book b) -> b.price).reversed())
                .map(b -> b.title)
                .collect(Collectors.toList());

        System.out.println(sortedTitles);
    }
}