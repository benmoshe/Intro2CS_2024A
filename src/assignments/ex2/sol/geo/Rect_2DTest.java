package assignments.ex2.sol.geo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rect_2DTest {
    private Rect_2D r1, r2;
    private  Point_2D p1_2, p4_6, cen;

    @BeforeEach
    void setUp() {
        p1_2 = new Point_2D(1, 2);
        p4_6 = new Point_2D(4, 6);
        cen = new Point_2D(p1_2);
        cen.scale(p4_6,0.5);
        r1 = new Rect_2D(p1_2, p4_6);
        r2 = new Rect_2D(p4_6, p1_2);
    }

    @Test
    void copy() {
        Rect_2D rr1 = new Rect_2D(r1);
        assertEquals(r1,rr1);
        r1.rotate(p1_2,0.95);
        assertNotEquals(r1,rr1);
    }

    @Test
    void add() {
        assertEquals(r1,r2);
        assertEquals(r2,r1);
        r1.add(Point_2D.ORIGIN); // makes sure that "add is doing nothing (not adding another point)
        assertEquals(r1,r2);
        r1.scale(Point_2D.ORIGIN,1.01);
        assertNotEquals(r1,r2);
    }

    @Test
    void rotate() {
        assertEquals(r1,r2);
        r1.rotate(cen,180);
        assertEquals(r1,r2);
        r1.rotate(cen,90);
        assertNotEquals(r1,r2);
        r1.rotate(cen,-90);
        assertEquals(r1,r2);
    }
}