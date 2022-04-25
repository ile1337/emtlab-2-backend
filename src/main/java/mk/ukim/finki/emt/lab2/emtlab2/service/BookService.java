package mk.ukim.finki.emt.lab2.emtlab2.service;

import mk.ukim.finki.emt.lab2.emtlab2.model.Book;
import mk.ukim.finki.emt.lab2.emtlab2.model.dtos.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save (BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    Optional<Book> taken(Long id);

    void deleteById(Long id);
}
