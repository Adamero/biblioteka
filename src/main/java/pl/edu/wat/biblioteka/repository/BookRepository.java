package pl.edu.wat.biblioteka.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import pl.edu.wat.biblioteka.entity.Book;

import java.util.Optional;

public interface BookRepository
        extends MongoRepository<Book, String> {
    Optional<Book> findBookByTytul(String title);
}
