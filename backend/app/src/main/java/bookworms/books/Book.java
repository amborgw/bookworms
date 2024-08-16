package backend.app.src.main.java.bookworms.books;

public abstract class Book {
    private String title;
    private String author;
    private int isbn;
    private String publishedDate;
    private String description;

    public Book(String title, String author, int isbn, String publishedDate, String description) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getDescription() {
        return description;
    }
}
