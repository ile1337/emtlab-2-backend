package mk.ukim.finki.emt.lab2.emtlab2.config;

import mk.ukim.finki.emt.lab2.emtlab2.model.Category;
import mk.ukim.finki.emt.lab2.emtlab2.model.dtos.BookDto;
import mk.ukim.finki.emt.lab2.emtlab2.service.AuthorService;
import mk.ukim.finki.emt.lab2.emtlab2.service.BookService;
import mk.ukim.finki.emt.lab2.emtlab2.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final CountryService countryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public DataInitializer(CountryService countryService, AuthorService authorService, BookService bookService) {
        this.countryService = countryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @PostConstruct
    public void initData(){

        for (int i = 1; i < 8; i++) {
            this.countryService.create("Country " + i,"Continent " + i);
        }
        for (int i = 1; i < 15; i++) {
            this.authorService.create("Author Name " + i, "Author Surname " + i, this.countryService.findAll().get((i-1) % 7));
        }
    }
}