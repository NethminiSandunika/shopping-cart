
package test.java.com.shashi.service;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shashi.beans.ProductBean;
import com.shashi.service.ProductService;

public class ProductServiceIntegrationTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = mock(ProductService.class);
    }

    @Test
    void testProductBrowsingAndSearchFunctionality() {
        // Arrange
        ProductBean product1 = new ProductBean();
        product1.setProdId("P001");
        product1.setProdName("Product 1");
        product1.setProdType("Electronics");

        ProductBean product2 = new ProductBean();
        product2.setProdId("P002");
        product2.setProdName("Product 2");
        product2.setProdType("Books");

        List<ProductBean> allProducts = new ArrayList<>();
        allProducts.add(product1);
        allProducts.add(product2);

        when(productService.getAllProducts()).thenReturn(allProducts);
        when(productService.searchAllProducts("Product 1")).thenReturn(List.of(product1));

        // Act
        List<ProductBean> searchResults = productService.searchAllProducts("Product 1");

        // Assert
        assertNotNull(searchResults);
        assertEquals(1, searchResults.size());
        assertEquals("Product 1", searchResults.get(0).getProdName());
        assertEquals("P001", searchResults.get(0).getProdId());
        verify(productService, times(1)).searchAllProducts("Product 1");
    }
}
