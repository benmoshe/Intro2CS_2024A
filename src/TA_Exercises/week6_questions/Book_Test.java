package TA_Exercises.week6_questions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Book_Test {
    @Test
    public void testBook() {
        Book book1 = new Book("Harry Potter", "J.K Rowling", 361, 75);
        assertEquals("Harry Potter", book1.getTitle());
        assertEquals("J.K Rowling", book1.getAuthor());
        assertEquals(75, book1.getPrice());

        book1.setPrice(100);
        assertEquals(100, book1.getPrice());
    }
}

