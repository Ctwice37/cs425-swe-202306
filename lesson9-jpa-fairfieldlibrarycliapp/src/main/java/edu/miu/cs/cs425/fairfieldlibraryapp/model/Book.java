package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books")
@NamedQuery(name = "Book.findScienceBooks", query = "select b from Book b where b.isbn like '978'")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String isbn;
    private String title;
    private LocalDate datePublished;

//    @OneToMany
    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = true)
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "books_authors",
            joinColumns = {@JoinColumn(name="book_id", referencedColumnName = "bookId")},
            inverseJoinColumns = {@JoinColumn(name="author_id", referencedColumnName = "authorId")}
    )
    private List<Author> authors;

    public Book(Long bookId, String isbn, String title, LocalDate datePublished, Publisher publisher) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.datePublished = datePublished;
        this.publisher = publisher;
    }

    public Book() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", datePublished=" + datePublished +
                ", publisher=" + publisher +
                '}';
    }
}
