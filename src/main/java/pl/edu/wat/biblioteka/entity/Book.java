package pl.edu.wat.biblioteka.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document
public class Book {
    @Id
    private String id;
    private String tytul;
    @Indexed(unique = true)
    private String opis;
    private Author author;
    private List<String> type;
    private LocalDateTime created;

    public Book(String title,
                String description,
                Author author,
                List<String> type,
                LocalDateTime created) {
        this.tytul = title;
        this.opis = description;
        this.author = author;
        this.type = type;
        this.created = created;
    }
}
