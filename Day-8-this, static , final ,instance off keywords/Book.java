public class Book {
    // Static variable
    private static String libraryName = "City Library";
    
    // Instance variables
    private String title;
    private String author;
    private final String isbn;

    // Constructor using this
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Instance method with instanceof check
    public void displayDetails(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            System.out.println("Book Details:");
            System.out.println("Library: " + libraryName);
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("ISBN: " + book.isbn);
        } else {
            System.out.println("Invalid object: Not a Book instance");
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("Java Basics", "John Doe", "ISBN001");
        Book book2 = new Book("Python Guide", "Jane Smith", "ISBN002");
        Book.displayLibraryName();
        book1.displayDetails(book1);
        book2.displayDetails(book2);
        book1.displayDetails(new String("Invalid"));
    }
}