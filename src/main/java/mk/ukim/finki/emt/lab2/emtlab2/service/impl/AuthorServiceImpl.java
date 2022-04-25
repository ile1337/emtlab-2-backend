package mk.ukim.finki.emt.lab2.emtlab2.service.impl;

import mk.ukim.finki.emt.lab2.emtlab2.model.Author;
import mk.ukim.finki.emt.lab2.emtlab2.model.Country;
import mk.ukim.finki.emt.lab2.emtlab2.repository.AuthorRepository;
import mk.ukim.finki.emt.lab2.emtlab2.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author create(String name, String surname, Country country) {
        Author author = new Author(name, surname, country);
        return authorRepository.save(author);
    }
}
