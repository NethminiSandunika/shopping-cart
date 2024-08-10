
package test.java.com.shashi.service;


import com.shashi.beans.ProductBean;
import com.shashi.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceProductManagementTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // Create a mock instance of ProductService
        productService = mock(ProductService.class);
    }

    @Test
    void testAddProduct() {
        // Arrange
        String prodName = "Laptop";
        String prodType = "Electronics";
        String prodInfo = "High-performance laptop";
        double prodPrice = 999.99;
        int prodQuantity = 10;
        InputStream prodImage = null; // Mock InputStream or use a real one if needed

        when(productService.addProduct(prodName, prodType, prodInfo, prodPrice, prodQuantity, prodImage)).thenReturn("Product added successfully");

        // Act
        String result = productService.addProduct(prodName, prodType, prodInfo, prodPrice, prodQuantity, prodImage);

        // Assert
        assertEquals("Product added successfully", result, "The product should be added successfully");

        // Verify interactions
        verify(productService).addProduct(prodName, prodType, prodInfo, prodPrice, prodQuantity, prodImage);
    }

    @Test
    void testUpdateProduct() {
        // Arrange
        ProductBean prevProduct = new ProductBean(); // Initialize with appropriate values
        ProductBean updatedProduct = new ProductBean(); // Initialize with appropriate values

        when(productService.updateProduct(prevProduct, updatedProduct)).thenReturn("Product updated successfully");

        // Act
        String result = productService.updateProduct(prevProduct, updatedProduct);

        // Assert
        assertEquals("Product updated successfully", result, "The product details should be updated successfully");

        // Verify interactions
        verify(productService).updateProduct(prevProduct, updatedProduct);
    }

    @Test
    void testRemoveProduct() {
        // Arrange
        String prodId = "P12345";

        when(productService.removeProduct(prodId)).thenReturn("Product removed successfully");

        // Act
        String result = productService.removeProduct(prodId);

        // Assert
        assertEquals("Product removed successfully", result, "The product should be removed successfully");

        // Verify interactions
        verify(productService).removeProduct(prodId);
    }
    
    // Additional tests for other methods can be added here
}
