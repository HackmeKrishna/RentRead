package main.java.repository;



import com.rentread.entity.Rental;
import com.rentread.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByUserAndReturnedFalse(User user);
}
