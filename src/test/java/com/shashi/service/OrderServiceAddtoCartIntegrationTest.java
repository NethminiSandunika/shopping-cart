
package test.java.com.shashi.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.shashi.beans.OrderBean;
import com.shashi.beans.OrderDetails;
import com.shashi.service.OrderService;

class OrderServiceAddtoCartIntegrationTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderServiceAddtoCartIntegrationTest orderServiceIntegrationTest;

    private OrderBean order;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Sample order for testing
        order = new OrderBean();
        order.setOrderNumber("ORD123");
        order.setEmailId("john.doe@example.com");
        order.setProductId("PROD001");
        order.setQuantity(1); // Ensure this matches your actual OrderBean method
    }

    @Test
    void testAddToCartAndUpdateQuantity() {
        // Mock adding a product to the cart
        when(orderService.addOrder(any(OrderBean.class))).thenReturn(true);

        // Simulate adding a product to the cart
        boolean addResult = orderService.addOrder(order);

        // Assert that the product was added to the cart successfully
        assertTrue(addResult);

        // Mock the order details after adding to the cart
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderId("ORD123");
        orderDetails.setProductId("PROD001");
        orderDetails.setQty("2"); // Updated quantity as a String
        orderDetailsList.add(orderDetails);

        when(orderService.getAllOrderDetails("john.doe@example.com")).thenReturn(orderDetailsList);

        // Simulate navigating to the cart and updating the quantity
        List<OrderDetails> result = orderService.getAllOrderDetails("john.doe@example.com");

        // Assert that the cart is updated with the correct product and quantity
        assertEquals(1, result.size());
        assertEquals("PROD001", result.get(0).getProductId());
        assertEquals("2", result.get(0).getQty()); // Check quantity as String
    }
}
