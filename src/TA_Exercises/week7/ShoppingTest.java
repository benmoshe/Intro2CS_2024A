package TA_Exercises.week7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingTest {

    @Test
    public void testShoppingConstructorInvalidDate() {
        // This should throw an exception because the date format is wrong
        assertThrows(RuntimeException.class, () -> {
            Shopping shopping = new Shopping("13-25-2023", 100.0, 60, "Shop");
        });
    }

    @Test
    public void testShoppingConstructorOldYear() {
        // This should throw an exception because the year is too old
        assertThrows(RuntimeException.class, () -> {
            Shopping shopping = new Shopping("12/31/2021", 100.0, 60, "Shop");
        });
    }

    @Test
    public void testShoppingConstructorValidDate() {
        // This should not throw an exception
        Shopping shopping = new Shopping("12/31/2022", 100.0, 60, "Shop");
        assertEquals("12/31/2022", shopping.getDateOfShopping());
    }

    @Test
    public void testDiscount() {
        // Test discount method
        Shopping shopping = new Shopping("12/31/2022", 100.0, 60, "Shop");
        shopping.discount(10);
        assertEquals(90.0, shopping.getPrice(), 0.001);
    }
}
