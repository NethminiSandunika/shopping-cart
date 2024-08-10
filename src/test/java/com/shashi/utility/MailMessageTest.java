
package test.java.com.shashi.utility;


import com.shashi.utility.MailMessage;
import jakarta.mail.MessagingException;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

public class MailMessageTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistrationSuccess() {
        // Arrange
        String emailId = "test@example.com";
        String name = "John Doe";
        
        // Act
        MailMessage.registrationSuccess(emailId, name); // Assert
        // Add assertions or verify interactions here if needed
    }

    @Test
    void testTransactionSuccess() {
        // Arrange
        String recipientEmail = "test@example.com";
        String name = "John Doe";
        String transId = "12345";
        double transAmount = 250.00;
        
        // Act
        MailMessage.transactionSuccess(recipientEmail, name, transId, transAmount); // Assert
        // Add assertions or verify interactions here if needed
    }

    @Test
    void testOrderShipped() {
        // Arrange
        String recipientEmail = "test@example.com";
        String name = "John Doe";
        String transId = "12345";
        double transAmount = 250.00;
        
        // Act
        MailMessage.orderShipped(recipientEmail, name, transId, transAmount); // Assert
        // Add assertions or verify interactions here if needed
    }

    @Test
    void testProductAvailableNow() {
        // Arrange
        String recipientEmail = "test@example.com";
        String name = "John Doe";
        String prodName = "Laptop";
        String prodId = "XYZ123";
        
        // Act
        MailMessage.productAvailableNow(recipientEmail, name, prodName, prodId); // Assert
        // Add assertions or verify interactions here if needed
    }
}
