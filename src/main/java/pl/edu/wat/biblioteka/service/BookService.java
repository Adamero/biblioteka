package pl.edu.wat.biblioteka.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wat.biblioteka.entity.Book;
import pl.edu.wat.biblioteka.repository.BookRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
