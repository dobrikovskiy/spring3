package ru.gb.springdemo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.repository.BookRepository;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        Book book = bookRepository.getBookById(id);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
        bookRepository.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.getAll();
    }
}
