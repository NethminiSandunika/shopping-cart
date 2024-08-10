
package test.java.com.shashi.system;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductBrowsingSystemTest {

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
    public void testBrowsingProducts() {
        // Navigate to the home page
        driver.get("http://localhost:8080/shopping-cart/home");

        // Locate the product listings
        List<WebElement> products = driver.findElements(By.className("product-item"));

        // Check if all products are displayed
        assertTrue(products.size() > 0, "No products found on the home page!");

        // Verify that each product has necessary details like name, price, and description
        for (WebElement product : products) {
            WebElement productName = product.findElement(By.className("product-name"));
            WebElement productPrice = product.findElement(By.className("product-price"));
            WebElement productDescription = product.findElement(By.className("product-description"));

            assertTrue(productName.isDisplayed(), "Product name is missing!");
            assertTrue(productPrice.isDisplayed(), "Product price is missing!");
            assertTrue(productDescription.isDisplayed(), "Product description is missing!");
        }
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
