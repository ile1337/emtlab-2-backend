package mk.ukim.finki.emt.lab2.emtlab2.web;

import mk.ukim.finki.emt.lab2.emtlab2.model.Author;
import mk.ukim.finki.emt.lab2.emtlab2.model.Book;
import mk.ukim.finki.emt.lab2.emtlab2.model.Category;
import mk.ukim.finki.emt.lab2.emtlab2.model.dtos.BookDto;
import mk.ukim.finki.emt.lab2.emtlab2.service.AuthorService;
import mk.ukim.finki.emt.lab2.emtlab2.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class BookRestController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookRestController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping(value = {"/", "/books"})
    private List<Book> findAll(){
        return this.bookService.findAll();
    }

    @GetMapping("books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("books/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return this.bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("books/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return this.bookService.edit(id, bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("books/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/categories")
    public ResponseEntity<Category[]> findCategories(){
        return ResponseEntity.ok().body(Category.values());
    }

    @GetMapping("/authors")
    public List<Author> findAuthors(){
        return this.authorService.findAll();
    }

    @PostMapping("/books/take/{id}")
    public ResponseEntity<Book> take(@PathVariable Long id) {
        return this.bookService.taken(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


}
