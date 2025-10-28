package Exer_11;
import java.util.ArrayList;

public class LibraryMain {
    private ArrayList<Book> books;

    LibraryMain() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        boolean confirmation = bookIdChecker(book.getBookID());

        if (confirmation) {
            System.out.println("this bookID is already used pick another one!");
        } else {
            books.add(book);
            System.out.println("Book " + book.getBookID() + " successfully added!");
        }
    }

    public void removeBook(String bookID) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookID().equals(bookID)) {
                books.remove(i);
                System.out.println("book " + bookID + " removed successfully!");
                return;
            }
        }

        System.out.println("This book did not exist in the library!");
    }

    public boolean bookIdChecker(String bookID) {
        for (Book book : books) {
            if (book.getBookID().equals(bookID))
                return true;
        }

        return false;

    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The Library is empty!");
            return;
        }

        System.out.println("----------Library Books----------");
        for (Book book : books)
            book.displayBook();
    }

    public static void main(String[] args) {

        LibraryMain shelf = new LibraryMain();

        Book book1 = new Book("Living Orchestra", "Johny", "001", 1925);
        Book book2 = new Book("happy days", "Stoie", "002", 1960);

        shelf.addBook(book1);
        shelf.addBook(book2);

        shelf.displayBooks();

        // trying to add a book with the same bookID
        Book book3 = new Book("To Kill", "Harper Lee", "002", 1960);
        shelf.addBook(book3);

        shelf.displayBooks();
        shelf.removeBook("003");


    }
}
