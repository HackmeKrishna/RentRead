package main.java.entity;
import javax.persistence.*;

@Getters
@Setters
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String genre;
    private boolean availabilityStatus = true; // true = available, false = rented
    // Getters and Setters
}
