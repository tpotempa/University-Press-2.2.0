package pl.edu.atar.university.press.data.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@MappedSuperclass
@Data
public abstract class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    private String isbn;

    @NotNull
    private String title;

    private String description;

    private LocalDate publishingDate;

    protected Book() {
    }

    protected Book(String isbn, String title, String description, LocalDate publishingDate) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.publishingDate = publishingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public abstract List<Author> getAuthors();

    public abstract void setAuthors(List<Author> authors);

    public abstract Set<Category> getCategories();

    public abstract void setCategories(Set<Category> categories);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(title, book.title) &&
                Objects.equals(description, book.description) &&
                Objects.equals(publishingDate, book.publishingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, title, description, publishingDate);
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "Książka [ISBN={0}, Tytuł={1}, Opis={2}, Data wydania={3}]",
                isbn, title, description, publishingDate
        );
    }

}