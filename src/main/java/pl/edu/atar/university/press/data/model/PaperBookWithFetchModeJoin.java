package pl.edu.atar.university.press.data.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static org.hibernate.annotations.FetchMode.JOIN;

@Entity
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class PaperBookWithFetchModeJoin extends Book {

    private String binding;

    @ManyToMany(fetch = EAGER)
    @Fetch(JOIN)
    private List<Author> authors = new ArrayList<>();

    @ManyToMany
    @Fetch(JOIN)
    private Set<Category> categories = new LinkedHashSet<>();

    public PaperBookWithFetchModeJoin() {
    }

    public PaperBookWithFetchModeJoin(String isbn, String title, String description, LocalDate publishingDate, String binding) {
        super(isbn, title, description, publishingDate);
        this.binding = binding;
    }

    @Override
    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public void setAuthors(List<Author> authors) {

    }

    @Override
    public Set<Category> getCategories() {
        return categories;
    }

    @Override
    public void setCategories(Set<Category> categories) {

    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

}