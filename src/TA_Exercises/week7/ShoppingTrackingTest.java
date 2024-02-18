package TA_Exercises.week7;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingTrackingTest {

    @Test
    public void testAddElement() {
        ShoppingTracking tracking = new ShoppingTracking();
        Shopping shopping1 = new Shopping("12/31/2022", 100.0, 60, "Shop1");
        Shopping shopping2 = new Shopping("12/31/2022", 200.0, 120, "Shop2");

        tracking.addElement(shopping1);
        assertEquals(1, tracking.getSize());

        assertThrows(RuntimeException.class, () -> tracking.addElement(shopping2));
    }

    @Test
    public void testAveragePrice() {
        ShoppingTracking tracking = new ShoppingTracking();
        Shopping shopping1 = new Shopping("12/31/2022", 100.0, 60, "Shop1");
        Shopping shopping2 = new Shopping("01/01/2023", 200.0, 120, "Shop2");

        tracking.addElement(shopping1);
        tracking.addElement(shopping2);
        assertEquals(150.0, tracking.averagePrice(), 0.001);
    }

    @Test
    public void testAveragePriceByShop() {
        ShoppingTracking tracking = new ShoppingTracking();
        Shopping shopping1 = new Shopping("12/31/2022", 100.0, 60, "Shop1");
        Shopping shopping2 = new Shopping("01/01/2023", 200.0, 120, "Shop1");
        Shopping shopping3 = new Shopping("01/02/2023", 300.0, 180, "Shop2");

        tracking.addElement(shopping1);
        tracking.addElement(shopping2);
        tracking.addElement(shopping3);
        assertEquals(150.0, tracking.averagePriceByShop("Shop1"), 0.001);
        assertEquals(300.0, tracking.averagePriceByShop("Shop2"), 0.001);
    }

    @Test
    public void testMergeShops() {
        ShoppingTracking tracking = new ShoppingTracking();
        Shopping shopping1 = new Shopping("12/31/2022", 100.0, 60, "YadYizhak");
        Shopping shopping2 = new Shopping("01/01/2023", 200.0, 120, "BitanWinery");

        tracking.addElement(shopping1);
        tracking.addElement(shopping2);
        tracking.mergeShops("YadYizhak", "BitanWinery");
        assertEquals("BitanWinery", tracking.getElementAt(0).getShopName());
    }

    @Test
    public void testCreateFile() {
        ShoppingTracking tracking = new ShoppingTracking();
        Shopping shopping1 = new Shopping("12/31/2022", 100.0, 60, "Shop1");
        Shopping shopping2 = new Shopping("01/01/2023", 200.0, 120, "Shop2");

        tracking.addElement(shopping1);
        tracking.addElement(shopping2);
        tracking.createFile("List_of_Shopping.txt");

        File file = new File("List_of_Shopping.txt");
        assertTrue(file.exists());
    }

    @Test
    public void testWriteToFile() throws IOException {
        ShoppingTracking tracking = new ShoppingTracking();
        Shopping shopping1 = new Shopping("12/31/2022", 100.0, 60, "Shop1");
        Shopping shopping2 = new Shopping("01/01/2023", 200.0, 120, "Shop2");

        tracking.addElement(shopping1);
        tracking.addElement(shopping2);
        tracking.writeToFile("List_of_Shopping.txt");

        String content = new String(Files.readAllBytes(Paths.get("List_of_Shopping.txt")));
        assertEquals(tracking.display(), content);
    }
}
