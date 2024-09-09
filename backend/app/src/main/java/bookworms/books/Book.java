package bookworms.books;

public abstract class Book {
    private String id;
    private String title;
    private String author;
    private int isbn;
    private String publishedDate;
    private String description;

    public Book(String id, String title, String author, int isbn, String publishedDate, String description) {
        this.id = id;
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
