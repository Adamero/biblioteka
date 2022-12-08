package pl.edu.wat.biblioteka.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
public class Role {
    @MongoId
    private Long id;
    private String name;
}
