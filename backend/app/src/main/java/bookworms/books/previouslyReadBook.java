package bookworms.books;

public class previouslyReadBook extends Book {
    int rating;
    String review; 

    public previouslyReadBook(String id, String title, String author, int isbn, String publishedDate, String description, int rating, String review) {
        super(id, title, author, isbn, publishedDate, description);
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