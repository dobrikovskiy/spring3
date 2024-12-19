package ru.gb.springdemo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.Reader;
import ru.gb.springdemo.repository.ReaderRepository;

import java.util.List;

@RestController
@RequestMapping("/reader")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderRepository readerRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Reader> getReaderById(@PathVariable long id) {
        Reader reader = readerRepository.getReaderById(id);
        return reader != null ? ResponseEntity.ok(reader) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Reader> createReader(@RequestBody Reader reader) {
        readerRepository.save(reader);
        return ResponseEntity.status(HttpStatus.CREATED).body(reader);
    }

    @GetMapping
    public List<Reader> getAllReaders() {
        return readerRepository.getAll();
    }
}
