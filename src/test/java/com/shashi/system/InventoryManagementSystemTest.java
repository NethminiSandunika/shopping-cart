
package test.java.com.shashi.system;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryManagementSystemTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Set up ChromeDriver (Ensure you have added WebDriverManager to handle this)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testUpdateInventoryLevels() {
        // Navigate to the login page
        driver.get("http://localhost:8080/shoping-cart/login");

        // Log in as admin
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginBtn"));

        usernameField.sendKeys("admin");  // Replace with actual admin username
        passwordField.sendKeys("adminpass");  // Replace with actual admin password
        loginButton.click();

        // Navigate to the inventory management section
        driver.get("http://localhost:8080/shoping-cart/admin/inventory");

        // Find the product to update inventory levels
        WebElement productRow = driver.findElement(By.xpath("//tr[td[contains(text(),'Existing Product Name')]]")); // Adjust locator based on your app
        WebElement updateStockField = productRow.findElement(By.name("quantity"));
        WebElement updateButton = productRow.findElement(By.name("updateButton"));

        // Update stock levels for the product
        updateStockField.clear();
        updateStockField.sendKeys("50");  // New inventory level
        updateButton.click();

        // Verify if the inventory levels are updated
        WebElement updatedProductRow = driver.findElement(By.xpath("//tr[td[contains(text(),'Existing Product Name')]]")); // Adjust locator based on your app
        WebElement updatedQuantity = updatedProductRow.findElement(By.name("quantity"));

        assertEquals("50", updatedQuantity.getAttribute("value"), "Inventory levels should be updated in the system.");
    }
}
