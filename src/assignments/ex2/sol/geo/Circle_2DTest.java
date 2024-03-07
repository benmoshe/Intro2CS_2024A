package assignments.ex2.sol.geo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static assignments.ex2.sol.ex2.Ex2_Const.EPS;
import static org.junit.jupiter.api.Assertions.*;

class Circle_2DTest {
    private Circle_2D c1, c2;
    private Point_2D q1, q2;

    @BeforeEach
    void setUp() {
        Point_2D p1_2 = new Point_2D(1, 2);
        Point_2D p4_6 = new Point_2D(4, 6);
        c1 = new Circle_2D(p1_2, 2);
        c2 = new Circle_2D(p4_6, 5);
    }

    @Test
    public void testBasics() {
        Circle_2D c0 = new Circle_2D(Point_2D.ORIGIN, 0);
        assertEquals(c0.area(), 0, EPS);
        assertEquals(c0.perimeter(), 0, EPS);
        assertEquals(c0.getCenter(), Point_2D.ORIGIN);

        Circle_2D c = new Circle_2D(c1.getCenter(), 1);
        double a = Math.PI * Math.pow(c.getRadius(), 2);
        assertEquals(c.area(), a, EPS);
        double p = Math.PI * 2 * c.getRadius();
        assertEquals(c.perimeter(), p, EPS);
        double n = 1.123;
        c.scale(c.getCenter(), n);
        assertEquals(c.perimeter(), p * n, EPS);
        assertEquals(c.area(), a * n * n, EPS);
        c.scale(c.getCenter(), 1/n);
        n=0.345;
        c.scale(c.getCenter(), n);
        assertEquals(c.perimeter(), p * n, EPS);
        assertEquals(c.area(), a * n * n, EPS);
    }

    @Test
    void testToString() {
        Circle_2D c11 = new Circle_2D(c1);
        assertEquals(c1, c11);
        Circle_2D c111 = new Circle_2D(c11.toString());
        assertEquals(c11, c111);
        double eps = EPS;
        c11.scale(c11.getCenter(), 1 + eps * 2);
        assertNotEquals(c11, c111);
    }

    @Test
    void contains() {
        boolean b1 = c1.contains(c1.getCenter());
        assertTrue(b1);
        b1 = c2.contains(c1.getCenter());
        assertTrue(b1);
        c2.scale(c2.getCenter(), 0.99);
        b1 = c2.contains(c1.getCenter());
        assertFalse(b1);
    }

    @Test
    void area() {
        Circle_2D c = new Circle_2D(c1.getCenter(), 1.4);
        double n = 1.123;
        double a = c.area();
        c.scale(c.getCenter(), n);
        assertEquals(c.area(), a * n * n, EPS);
        c.scale(c.getCenter(), 1/n);
        assertEquals(c.area(), a, EPS);
        n=0.345;
        c.scale(c.getCenter(), n);
        assertEquals(c.area(), a * n * n, EPS);
        c.scale(c.getCenter(), 1/n);
        c.rotate(c2.getCenter(),123);
        c.translate(c1.getCenter());
        assertEquals(c.area(), a, EPS);
    }
    @Test
    void perimeter() {
        Circle_2D c = new Circle_2D(c1.getCenter(), 1.4);
        double n = 1.123;
        double p = c.perimeter();
        c.scale(c.getCenter(), n);
        assertEquals(c.perimeter(), p * n, EPS);
        c.scale(c.getCenter(), 1/n);
        assertEquals(c.perimeter(), p, EPS);
        n=0.345;
        c.scale(c.getCenter(), n);
        assertEquals(c.perimeter(), p * n, EPS);
        c.scale(c.getCenter(), 1/n);
        c.rotate(c2.getCenter(),123);
        c.translate(c1.getCenter());
        assertEquals(c.perimeter(), p, EPS);
    }

    @Test
    void translate() {
        Circle_2D c = new Circle_2D(c1);
        Point_2D v = c1.getCenter().vector(c2.getCenter());
        Point_2D v1 = new Point_2D(-v.x(), -v.y());
        c1.translate(v);
        assertNotEquals(c,c1);
        c1.translate(v1);
       assertEquals(c,c1);
    }

    @Test
    void copy() {
       GeoShape c = c1.copy();
       assertEquals(c, c1);
    }

    @Test
    void scale() {
        Circle_2D c = new Circle_2D(c1);
        double n = 0.123;
        c.scale(c2.getCenter(), n);
        c.scale(c2.getCenter(), 1/n);
        assertTrue(c.close2Equals(c1));
    }
    @Test
    void rotate() {
        Circle_2D c = new Circle_2D(c1);
        c.rotate(c.getCenter(), 123);
        assertEquals(c,c1);
    }
}