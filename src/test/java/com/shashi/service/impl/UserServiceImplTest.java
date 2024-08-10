package test.java.com.shashi.service.impl;

import com.shashi.beans.UserBean;
import com.shashi.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceImplTest {

    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        userService = new UserServiceImpl();
    }

@Test
public void testRegisterUser_ValidData() {
    // Given a new, unique user data
    String userName = "testUser";
    Long mobileNo = 1234567890L;
    String emailId = "newuser@example.com";  // Ensure this is unique
    String address = "123 Test Street";
    int pinCode = 123456;
    String password = "securePassword";

    // When registering the user
    String result = userService.registerUser(userName, mobileNo, emailId, address, pinCode, password);

    // Then the registration should be successful
    assertEquals("success", result); // Assuming "success" is the expected outcome
}


    @Test
    public void testRegisterUser_MissingRequiredFields() {
        // Given user data with missing required fields
        String userName = "";
        Long mobileNo = null;
        String emailId = "";
        String address = "";
        int pinCode = 0;
        String password = "";

        // When registering the user
        String result = userService.registerUser(userName, mobileNo, emailId, address, pinCode, password);

        // Then the registration should fail
        assertEquals("error", result); // Adjust based on actual expected result
    }

    @Test
    public void testIsValidCredential_Valid() {
        // Given valid credentials
        String emailId = "test@example.com";
        String password = "securePassword";

        // When validating the credentials
        String result = userService.isValidCredential(emailId, password);

        // Then the result should indicate success
        assertEquals("valid", result); // Adjust based on actual expected result
    }

    @Test
    public void testIsValidCredential_Invalid() {
        // Given invalid credentials
        String emailId = "wrong@example.com";
        String password = "wrongPassword";

        // When validating the credentials
        String result = userService.isValidCredential(emailId, password);

        // Then the result should indicate failure
        assertEquals("Login Denied! Incorrect Username or Password", result); // Adjust based on actual expected result
    }
}
