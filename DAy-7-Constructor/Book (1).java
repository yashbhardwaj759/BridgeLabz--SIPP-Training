public class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public methods to access/modify private author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book {
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void displayEBookDetails() {
        System.out.println("EBook Details:");
        System.out.println("ISBN: " + ISBN); // Public member
        System.out.println("Title: " + title); // Protected member
        System.out.println("Author: " + getAuthor()); // Private member via getter
    }

    public static void main(String[] args) {
        Book book = new Book("123456", "Java Guide", "John Smith");
        EBook ebook = new EBook("789012", "Python Guide", "Jane Doe");
        book.displayDetails();
        ebook.displayEBookDetails();
        ebook.setAuthor("Jane Smith");
        ebook.displayEBookDetails();
    }
}