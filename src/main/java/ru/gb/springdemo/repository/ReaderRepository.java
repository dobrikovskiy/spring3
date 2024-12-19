package ru.gb.springdemo.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.springdemo.model.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ReaderRepository {

  private final List<Reader> readers;

  public ReaderRepository() {
    this.readers = new ArrayList<>();
  }

  @PostConstruct
  public void generateData() {
    readers.addAll(List.of(
            new Reader("Игорь"),
            new Reader("Алексей"),
            new Reader("Мария")
    ));
  }

  public Reader getReaderById(long id) {
    return readers.stream().filter(it -> Objects.equals(it .getId(), id))
            .findFirst()
            .orElse(null);
  }

  public void save(Reader reader) {
    readers.add(reader);
  }

  public List<Reader> getAll() {
    return List.copyOf(readers);
  }
}