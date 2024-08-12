/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test.java.com.shashi.service;

import com.shashi.beans.CartBean;
import com.shashi.service.CartService;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author VISION
 */
public class CartServiceIT {
    
    public CartServiceIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addProductToCart method, of class CartService.
     */
    @Test
    public void testAddProductToCart() {
        System.out.println("addProductToCart");
        String userId = "";
        String prodId = "";
        int prodQty = 0;
        CartService instance = new CartServiceImpl();
        String expResult = "";
        String result = instance.addProductToCart(userId, prodId, prodQty);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProductToCart method, of class CartService.
     */
    @Test
    public void testUpdateProductToCart() {
        System.out.println("updateProductToCart");
        String userId = "";
        String prodId = "";
        int prodQty = 0;
        CartService instance = new CartServiceImpl();
        String expResult = "";
        String result = instance.updateProductToCart(userId, prodId, prodQty);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllCartItems method, of class CartService.
     */
    @Test
    public void testGetAllCartItems() {
        System.out.println("getAllCartItems");
        String userId = "";
        CartService instance = new CartServiceImpl();
        List<CartBean> expResult = null;
        List<CartBean> result = instance.getAllCartItems(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCartCount method, of class CartService.
     */
    @Test
    public void testGetCartCount() {
        System.out.println("getCartCount");
        String userId = "";
        CartService instance = new CartServiceImpl();
        int expResult = 0;
        int result = instance.getCartCount(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCartItemCount method, of class CartService.
     */
    @Test
    public void testGetCartItemCount() {
        System.out.println("getCartItemCount");
        String userId = "";
        String itemId = "";
        CartService instance = new CartServiceImpl();
        int expResult = 0;
        int result = instance.getCartItemCount(userId, itemId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeProductFromCart method, of class CartService.
     */
    @Test
    public void testRemoveProductFromCart() {
        System.out.println("removeProductFromCart");
        String userId = "";
        String prodId = "";
        CartService instance = new CartServiceImpl();
        String expResult = "";
        String result = instance.removeProductFromCart(userId, prodId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAProduct method, of class CartService.
     */
    @Test
    public void testRemoveAProduct() {
        System.out.println("removeAProduct");
        String userId = "";
        String prodId = "";
        CartService instance = new CartServiceImpl();
        boolean expResult = false;
        boolean result = instance.removeAProduct(userId, prodId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class CartServiceImpl implements CartService {

        public String addProductToCart(String userId, String prodId, int prodQty) {
            return "";
        }

        public String updateProductToCart(String userId, String prodId, int prodQty) {
            return "";
        }

        public List<CartBean> getAllCartItems(String userId) {
            return null;
        }

        public int getCartCount(String userId) {
            return 0;
        }

        public int getCartItemCount(String userId, String itemId) {
            return 0;
        }

        public String removeProductFromCart(String userId, String prodId) {
            return "";
        }

        public boolean removeAProduct(String userId, String prodId) {
            return false;
        }
    }
    
}
