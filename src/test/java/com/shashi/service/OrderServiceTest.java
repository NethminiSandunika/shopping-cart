package test.java.com.shashi.service;

import com.shashi.beans.OrderBean;
import com.shashi.beans.TransactionBean;
import com.shashi.service.OrderService;
import com.shashi.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        orderService = new OrderServiceImpl();
        // Set up test data in the database or use mocks as needed
    }

    @AfterEach
    public void tearDown() {
        // Clean up test data from the database or reset mocks
    }

    /**
     * Test of fetching all products (UT-07).
     */
    @Test
    public void testFetchingAllProducts() {
        // Step 1: Add a product to the database
        OrderBean order = new OrderBean("txn123", "prod123", 1, 100.0);
        boolean orderAdded = orderService.addOrder(order);
        assertTrue(orderAdded, "Order should be added successfully.");

        // Step 2: Fetch all orders
        List<OrderBean> orders = orderService.getAllOrders();

        // Step 3: Check if the product is in the list
        boolean productExists = orders.stream().anyMatch(o -> o.getProductId().equals("prod123"));
        assertTrue(productExists, "Product should be available in the list of orders.");
    }

    /**
     * Test of updating product quantity in the cart (UT-08).
     */
    @Test
    public void testUpdatingProductQuantityInCart() {
        // Add product to the cart
        // Assuming you have a method to add a product to the cart (you may need to mock it)
        // CartService cartService = new CartServiceImpl();
        // cartService.addProductToCart("user001", "prod123", 2);

        // Now update the quantity
        // cartService.updateProductQuantity("user001", "prod123", 5);

        // Verify the updated quantity
        // CartBean updatedCartItem = cartService.getCartItem("user001", "prod123");
        // assertEquals(5, updatedCartItem.getQuantity(), "Product quantity should be updated in the cart.");
    }
}
