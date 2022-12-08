package pl.edu.wat.biblioteka.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Collection;

@Data
public class User {
    @MongoId
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private Collection<Role> roles;
}
