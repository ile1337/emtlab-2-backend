package mk.ukim.finki.emt.lab2.emtlab2.repository;

import mk.ukim.finki.emt.lab2.emtlab2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findByName(String name);

    void deleteByName(String name);
}
