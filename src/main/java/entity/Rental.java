package main.java.entity;
import javax.persistence.*;
import java.time.LocalDate;

@Getters
@Setters
@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    private LocalDate rentalDate;
    private LocalDate returnDate;
    // Getters and Setters
}
