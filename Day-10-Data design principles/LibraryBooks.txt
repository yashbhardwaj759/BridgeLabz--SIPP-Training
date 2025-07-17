import java.util.Scanner;

/**
 * Demonstrates aggregation: Library aggregates Book objects, but Books can exist independently.
 * Guideline #1: Uses composition (aggregation) instead of inheritance.
 */
public class LibraryBooks {
    // Book class
    static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getDetails() {
            return "Book: " + title + ", Author: " + author;
        }
    }

    // Library class (aggregates Books)
    static class Library {
        private String name;
        private Book[] books;
        private int bookCount;
        private static final int MAX_BOOKS = 100;

        public Library(String name) {
            this.name = name;
            this.books = new Book[MAX_BOOKS];
            this.bookCount = 0;
        }

        public void addBook(Book book) {
            if (bookCount >= MAX_BOOKS) {
                throw new IllegalStateException("Library is full");
            }
            books[bookCount++] = book;
        }

        public String displayBooks() {
            StringBuilder sb = new StringBuilder("Library: " + name + "\nBooks:\n");
            for (int i = 0; i < bookCount; i++) {
                sb.append(books[i].getDetails()).append("\n");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter library name: ");
        String libraryName = scanner.nextLine();

        Library library1 = new Library(libraryName);
        Library library2 = new Library("City Library");

        System.out.print("Enter number of books to add: ");
        int numBooks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numBooks; i++) {
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            System.out.print("Enter book author: ");
            String author = scanner.nextLine();
            Book book = new Book(title, author);
            library1.addBook(book);
            if (i % 2 == 0) { // Some books shared with library2
                library2.addBook(book);
            }
        }

        System.out.println(library1.displayBooks());
        System.out.println(library2.displayBooks());

        scanner.close();
    }
}