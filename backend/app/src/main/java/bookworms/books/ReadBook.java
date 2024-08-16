package backend.app.src.main.java.bookworms.books;

public class ReadBook extends Book {
    int rating;
    String review; 

    public ReadBook(String title, String author, int isbn, String publishedDate, String description, int rating, String review) {
        super(title, author, isbn, publishedDate, description);
        this.rating = rating;
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }
}