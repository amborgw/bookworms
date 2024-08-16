package backend.app.src.main.java.bookworms.books;

public class CurrentlyReadingBook extends Book {
    private String startDate;

    public CurrentlyReadingBook(String title, String author, int isbn, String publishedDate, String description, String startDate) {
        super(title, author, isbn, publishedDate, description);
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }
}