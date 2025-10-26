package Exer_11;
class Book {
    private String title, author, bookID;
    private int year;

    Book(String title, String author, String bookID, int year) {
        this.title = title;
        this.author = author;
        this.bookID = bookID;
        this.year = year;

    }

    public String getBookID() {
        return bookID;
    }

    public void displayBook() {
        System.out.println("\nTitle: " + title);
        System.out.println("Author: " + author);
        System.out.println("BookId: " + bookID);
        System.out.println("Year: " + year);
    }
}