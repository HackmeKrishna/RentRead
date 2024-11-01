package main.java.service;



import com.rentread.entity.*;
import com.rentread.exception.RentalLimitExceededException;
import com.rentread.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public Rental rentBook(User user, Book book) {
        if (rentalRepository.countByUserAndReturnDateIsNull(user) >= 2) {
            throw new RentalLimitExceededException("User cannot rent more than 2 books");
        }
        Rental rental = new Rental();
        rental.setUser(user);
        rental.setBook(book);
        rental.setRentalDate(LocalDate.now());
        return rentalRepository.save(rental);
    }
}
