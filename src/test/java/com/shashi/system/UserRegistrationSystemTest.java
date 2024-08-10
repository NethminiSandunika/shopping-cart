
package test.java.com.shashi.system;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRegistrationSystemTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Set up WebDriverManager to manage ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testUserRegistration() {
        // Navigate to the registration page
        driver.get("http://localhost:8080/shopping-cart/register");

        // Enter registration details
        driver.findElement(By.id("username")).sendKeys("guest");
        driver.findElement(By.id("email")).sendKeys("guest@example.com");
        driver.findElement(By.id("password")).sendKeys("guest");
        driver.findElement(By.id("confirmPassword")).sendKeys("guest");

        // Submit the form
        driver.findElement(By.id("registerButton")).click();

        // Check if the user is registered and redirected to the login page
        String currentUrl = driver.getCurrentUrl();
        assertEquals("http://localhost:8080/your-app/login", currentUrl);
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
