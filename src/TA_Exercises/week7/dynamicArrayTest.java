package TA_Exercises.week7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class dynamicArrayTest {

    @Test
    public void testdynamicArray() {
        dynamicArray array = new dynamicArray();
        // Test addElement method
        for (int i = 0; i < 10; i++) {
            array.addElement(i);
        }
        assertEquals(10, array.getSize());

        // Test growSize method
        array.addElement(10);
        assertEquals(20, array.getCapacity());

        // Test addElementAt method
        array.addElementAt(5, 5);
        assertEquals(5, array.getElementAt(5));

        // Test removeElement method
        array.removeElement();
        assertEquals(11, array.getSize());

        // Test removeElementAt method
        array.removeElementAt(5);
        assertEquals(4, array.getElementAt(5));

        // Test shrinkSize method
        array.shrink();
        assertEquals(10, array.getCapacity());

    }
    @Test
    public void testAddElementAtInvalidIndex() {
        // This should throw an exception because the index is out of bounds
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dynamicArray array = new dynamicArray();
            array.addElementAt(5, 11);
        });
    }

    @Test
    public void testRemoveElementAtInvalidIndex() {
        // This should throw an exception because the index is out of bounds
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dynamicArray array = new dynamicArray();
            array.removeElementAt(11);
        });
    }
}
