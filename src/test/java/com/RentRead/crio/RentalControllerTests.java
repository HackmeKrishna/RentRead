package test.java.com.RentRead.crio;



import com.rentread.entity.Book;
import com.rentread.entity.User;
import com.rentread.entity.Rental;
import com.rentread.service.RentalService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(RentalController.class)
public class RentalControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RentalService rentalService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testRentBook() throws Exception {
        User user = new User("user@example.com", "password", "First", "Last", "USER");
        Book book = new Book("Title", "Author", "Genre", true);
        Rental rental = new Rental(user, book);

        Mockito.when(rentalService.rentBook(Mockito.any(User.class), Mockito.any(Book.class)))
                .thenReturn(rental);

        mockMvc.perform(post("/books/1/rent")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
