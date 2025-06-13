package pl.edu.atar.university.press.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.atar.university.press.data.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}