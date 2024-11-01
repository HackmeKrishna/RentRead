package main.java.controller;



import com.rentread.entity.Book;
import com.rentread.entity.Rental;
import com.rentread.entity.User;
import com.rentread.service.RentalService;
import com.rentread.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @Autowired
    private UserService userService;

    @PostMapping("/books/{bookId}/rent")
    public ResponseEntity<String> rentBook(@AuthenticationPrincipal User currentUser, @PathVariable Long bookId) {
        rentalService.rentBook(currentUser, bookId);
        return ResponseEntity.ok("Book rented successfully");
    }

    @PostMapping("/books/{bookId}/return")
    public ResponseEntity<String> returnBook(@AuthenticationPrincipal User currentUser, @PathVariable Long bookId) {
        rentalService.returnBook(currentUser, bookId);
        return ResponseEntity.ok("Book returned successfully");
    }

    @GetMapping
    public ResponseEntity<List<Rental>> getUserRentals(@AuthenticationPrincipal User currentUser) {
        List<Rental> rentals = rentalService.getRentalsByUser(currentUser);
        return ResponseEntity.ok(rentals);
    }
}
