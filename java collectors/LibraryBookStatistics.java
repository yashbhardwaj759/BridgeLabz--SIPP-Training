package JavaCollectors;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LibraryBookStatistics {

    static class Book {
        String title;
        String genre;
        int pages;

        public Book(String title, String genre, int pages) {
            this.title = title;
            this.genre = genre;
            this.pages = pages;
        }

        public String getTitle() {
            return title;
        }

        public String getGenre() {
            return genre;
        }

        public int getPages() {
            return pages;
        }

        @Override
        public String toString() {
            return "Book{title='" + title + "', genre='" + genre + "', pages=" + pages + "}";
        }
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("The Lord of the Rings", "Fantasy", 1178),
                new Book("Pride and Prejudice", "Romance", 279),
                new Book("The Hobbit", "Fantasy", 310),
                new Book("To Kill a Mockingbird", "Fiction", 281),
                new Book("Sense and Sensibility", "Romance", 400)
        );

        // Group books by genre and collect statistics on pages using Collectors.summarizingInt()
        Map<String, IntSummaryStatistics> genrePageStatistics = books.stream()
                .collect(Collectors.groupingBy(
                        Book::getGenre,
                        Collectors.summarizingInt(Book::getPages)
                ));

        System.out.println("Library Book Statistics by Genre:");
        genrePageStatistics.forEach((genre, stats) -> {
            System.out.println("Genre: " + genre);
            System.out.println("  Total Pages: " + stats.getSum());
            System.out.println("  Average Pages: " + String.format("%.2f", stats.getAverage()));
            System.out.println("  Maximum Pages: " + stats.getMax());
            System.out.println("  Minimum Pages: " + stats.getMin());
            System.out.println("  Count: " + stats.getCount());
            System.out.println();
        });
    }
}