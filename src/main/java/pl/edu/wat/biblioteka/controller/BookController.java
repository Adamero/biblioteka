package pl.edu.wat.biblioteka.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.biblioteka.entity.Book;
import pl.edu.wat.biblioteka.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> fetchAllBooks(){
        return bookService.getAllBooks();
    }

}
