package Exer_5;
import java.util.ArrayList;

public class BookMain {

    private String title;
    private String author;
    private String ISBN;

    private static ArrayList<BookMain> collections = new ArrayList<>();

    BookMain(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public static void addBook(BookMain book) {
        collections.add(book);
    }

    public static void removeBook(BookMain book) {
        collections.remove(book);
    }

    public static void showBooks() {
        System.out.println("Book Collection: \n");
        for (BookMain book : collections) {
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("ISBN: " + book.ISBN);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        BookMain book1 = new BookMain("The Family", "Robert", "978-0-618-00221-3");
        BookMain book2 = new BookMain("Finding Peace", "Escanor", "978-0-06-112008-4");
        BookMain book3 = new BookMain("Life", "Wilson", "978-0-590-35340-3");

        // add 3 books
        addBook(book1);
        addBook(book2);
        addBook(book3);

        // show all books
        showBooks();

        removeBook(book3);

        // show updated collections
        showBooks();
    }
}
