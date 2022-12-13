package pl.edu.wat.biblioteka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import pl.edu.wat.biblioteka.entity.Author;
import pl.edu.wat.biblioteka.entity.Book;
import pl.edu.wat.biblioteka.repository.BookRepository;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class BibliotekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliotekaApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(BookRepository repository, MongoTemplate mongoTemplate){
        return args -> {
            Author author = new Author(
                    "Ania",
                    "Zielonka"
            );

            String title = "Ania z zielonego wzgorza";
            Book book = new Book(
                    title,
                    "Ksiazka o jakiejs tam Ani",
                    author,
                    List.of("Sci-fi", "Drama"),
                    LocalDateTime.now()
            );
            repository.findBookByTytul(title)
                    .ifPresentOrElse(b -> {
                        System.out.println(book + "already exists");
                    }, () -> {
                        System.out.println("Inserting book " + book);
                        repository.insert(book);
                    });
            /*
            Query query = new Query();
            query.addCriteria(Criteria.where("tytul").is(tytul));

            List<Book> books = mongoTemplate.find(query, Book.class);

            if(books.size() > 1){
                throw new IllegalStateException("found many books with tytul" + tytul);
            }

            if(books.isEmpty()){
                System.out.println("Inserting book " + book);
                repository.insert(book);
            } else{
                System.out.println(book + "already exists");
            }
*/

        };
    }

}
