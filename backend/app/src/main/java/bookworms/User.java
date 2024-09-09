package bookworms;

import java.util.*;
import bookworms.books.*;

public class User {
    private String id;
    private String username;
    private String email;
    private String name;
    private List<String> tokens = new ArrayList<>();
    private List<previouslyReadBook> previouslyReadBooks;
    private List<CurrentlyReadingBook> currentlyReadingBooks;
    private List<ToBeReadBook> toBeReadBooks;

    // called when new user is created (to store in database)
    public User(String id, String username, String email, String name, String token) {
        this.id = id;
        this.username = username; 
        this.email = email;
        this.name = name;
        this.tokens.add(token);
    }

    // called when user info from database needs to be retrieved
    public User(String id, String username, String email, String name, List<previouslyReadBook> readBooks, List<CurrentlyReadingBook> currentlyReadingBooks, List<ToBeReadBook> toBeReadBooks) {
        this.id = id;
        this.username = username; 
        this.email = email;
        this.name = name;
        
        for (previouslyReadBook book : readBooks) {
            this.previouslyReadBooks.add(book);
        }

        for (CurrentlyReadingBook book : currentlyReadingBooks) {
            this.currentlyReadingBooks.add(book);
        }

        for (ToBeReadBook book : toBeReadBooks) {
            this.toBeReadBooks.add(book);
        }
    }

    public List<String> getTokens() {
        return tokens;
    }

    public void addToken(String token) {
        this.tokens.add(token);
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<previouslyReadBook> getReadBooks() {
        return previouslyReadBooks;
    }

    public void setReadBooks(List<previouslyReadBook> readBooks) {
        this.previouslyReadBooks = readBooks;
    }

    public List<CurrentlyReadingBook> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public void setCurrentlyReadingBooks(List<CurrentlyReadingBook> currentlyReadingBooks) {
        this.currentlyReadingBooks = currentlyReadingBooks;
    }

    public List<ToBeReadBook> getToBeReadBooks() {
        return toBeReadBooks;
    }

    public void setToBeReadBooks(List<ToBeReadBook> toBeReadBooks) {
        this.toBeReadBooks = toBeReadBooks;
    }
}
