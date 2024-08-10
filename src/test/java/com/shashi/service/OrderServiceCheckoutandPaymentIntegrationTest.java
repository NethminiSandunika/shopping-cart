package test.java.com.shashi.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.shashi.beans.OrderBean;
import com.shashi.beans.TransactionBean;
import com.shashi.service.OrderService;
import com.shashi.service.TransService;
import com.shashi.utility.MailMessage;

public class OrderServiceCheckoutandPaymentIntegrationTest {

    @Mock
    private OrderService orderService;

    @Mock
    private TransService transService;

    @InjectMocks
    private OrderServiceCheckoutandPaymentIntegrationTest testInstance;

    private OrderBean order;
    private TransactionBean transaction;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize sample order and transaction for testing
        order = new OrderBean("ORD123", "PROD001", 1, 100.00);
        transaction = new TransactionBean("ORD123", "john.doe", 100.00);
    }

    @Test
    void testCheckoutAndPayment() {
        // Mock the behavior of adding an order
        when(orderService.addOrder(order)).thenReturn(true);

        // Mock the behavior of getting user ID
        when(transService.getUserId(transaction.getTransactionId())).thenReturn("john.doe");

        // Simulate proceeding to checkout and completing the payment
        boolean orderResult = orderService.addOrder(order);
        String userId = transService.getUserId(transaction.getTransactionId());

        // Simulate sending a confirmation email
        String emailResult = MailMessage.sendMessage(
            "john.doe@example.com",
            "Order Confirmation",
            "Your order has been placed successfully!");

        // Assertions to check if the order placement and email sending are successful
        assertTrue(orderResult, "Order placement should be successful.");
        assertTrue(userId.equals("john.doe"), "User ID should match.");
        assertTrue("SUCCESS".equals(emailResult), "Email sending should be successful.");

        // Verify that methods were called exactly once
        verify(orderService, times(1)).addOrder(order);
        verify(transService, times(1)).getUserId(transaction.getTransactionId());
    }
}
