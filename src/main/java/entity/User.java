package main.java.entity;
import javax.persistence.*;

@Getters
@Setters
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String role = "USER";
}
