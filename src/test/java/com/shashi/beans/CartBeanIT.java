package test.java.com.shashi.beans;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartBeanIT {

    @Test
    public void testSimple() throws Exception {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit NetBeans
        driver.get("http://www.netbeans.org");

        // Wait for the page to load, timeout after 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().contains("NetBeans");
            }
        });

        // Close the browser
        driver.quit();
    }
}
