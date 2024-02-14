package TA_Exercises.week7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookConstructorInvalidPrice() {
        // This should throw an exception because the price is less than 10
        assertThrows(RuntimeException.class, () -> {
            Book book = new Book("Title", "Author", 100, 5);
        });
    }

    @Test
    public void testBookConstructorInvalidPrice2() {
        // This should throw an exception because the price is greater than 300
        assertThrows(RuntimeException.class, () -> {
            Book book = new Book("Title", "Author", 100, 305);
        });
    }

    @Test
    public void testBookConstructorValidPrice() {
        // This should not throw an exception
        Book book = new Book("Title", "Author", 100, 50);
        assertEquals(50, book.getPrice());
    }
}
