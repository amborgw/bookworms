package bookworms.books;

public class CurrentlyReadingBook extends Book {
    private String startDate;

    public CurrentlyReadingBook(String id, String title, String author, int isbn, String publishedDate, String description, String startDate) {
        super(id, title, author, isbn, publishedDate, description);
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }
}