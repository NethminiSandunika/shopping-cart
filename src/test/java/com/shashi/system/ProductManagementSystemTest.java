
package test.java.com.shashi.system;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductManagementSystemTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Set the path to the chromedriver executable if not using WebDriverManager
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void testAddingNewProduct() {
        // Navigate to the admin login page
        driver.get("http://localhost:8080/your-app/admin/login");

        // Log in as admin
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("login"));

        usernameField.sendKeys("admin@gmail.com");  // Replace with admin username
        passwordField.sendKeys("admin");  // Replace with admin password
        loginButton.click();

        // Navigate to the product management section
        driver.get("http://localhost:8080/your-app/admin/products");

        // Enter product details
        WebElement productNameField = driver.findElement(By.name("productName"));
        WebElement productPriceField = driver.findElement(By.name("productPrice"));
        WebElement productDescriptionField = driver.findElement(By.name("productDescription"));
        WebElement saveButton = driver.findElement(By.name("saveProduct"));

        productNameField.sendKeys("Test Product");
        productPriceField.sendKeys("99.99");
        productDescriptionField.sendKeys("This is a test product.");
        saveButton.click();

        // Check if the new product is added to the catalog
        WebElement productList = driver.findElement(By.id("productList"));
        assertTrue(productList.getText().contains("Test Product"), "New product was not added to the catalog!");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
