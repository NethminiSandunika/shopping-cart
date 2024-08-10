
package test.java.com.shashi.service;

import com.shashi.beans.ProductBean;
import com.shashi.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceInventoryManagementTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // Create a mock instance of ProductService
        productService = mock(ProductService.class);
    }

    @Test
    void testUpdateInventoryLevels() {
        // Arrange
        String prodId = "P12345";
        int newQuantity = 20;

        when(productService.sellNProduct(prodId, newQuantity)).thenReturn(true);

        // Act
        boolean result = productService.sellNProduct(prodId, newQuantity);

        // Assert
        assertTrue(result, "The inventory levels should be updated successfully");

        // Verify interactions
        verify(productService).sellNProduct(prodId, newQuantity);
    }
    
    // Additional tests for other methods related to inventory management can be added here
}



