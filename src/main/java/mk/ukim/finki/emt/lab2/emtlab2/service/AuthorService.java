package mk.ukim.finki.emt.lab2.emtlab2.service;

import mk.ukim.finki.emt.lab2.emtlab2.model.Author;
import mk.ukim.finki.emt.lab2.emtlab2.model.Country;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Author create(String name, String surname, Country country);
}
