package assignments.ex2.sol.geo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static classes.week6.Point2D.EPS;
import static org.junit.jupiter.api.Assertions.*;

public class Polygon_2DTest {
    private Polygon_2D po3, po4, po6, po17;
    private Point_2D p1,p2,p3,p4;
    private Polygon_2D s1,s2,s3,s4;
    @BeforeEach
    void setUp() {
        po3 = conv_poly(Point_2D.ORIGIN, 3, 1);
        po4 = conv_poly(Point_2D.ORIGIN, 4, 1);
        po6 = conv_poly(Point_2D.ORIGIN, 6, 5);
        po17 = conv_poly(Point_2D.ORIGIN, 17, 2);
        po6.translate(new Point_2D(1,1));
    }

    @Test
    void getAllPoints() {
        Point_2D[] ps = po17.getAllPoints();
        Polygon_2D p17 = new Polygon_2D();
        for (int i=0;i<ps.length;i=i+1) {
            p17.add(ps[i]);
        }
        assertEquals(p17, po17);
        p17.add(Point_2D.ORIGIN);
        assertNotEquals(p17, po17);
        po17.add(Point_2D.ORIGIN);
        assertEquals(p17, po17);
    }
    @Test
    void contains() {
        Point_2D[] ps = po17.getAllPoints();
        for (int i=0;i<ps.length;i=i+1) {
            assertTrue(po17.contains(ps[i]));
        }
        po17.scale(Point_2D.ORIGIN, 1.1);
        for (int i=0;i<ps.length;i=i+1) {
            assertTrue(po17.contains(ps[i]));
        }
        po17.scale(Point_2D.ORIGIN, 0.8);
        for (int i=0;i<ps.length;i=i+1) {
            assertFalse(po17.contains(ps[i]));
        }
    }

    @Test
    void simple() {
        double p = po17.perimeter();
        double a = po17.area();
        po17.rotate(Point_2D.ORIGIN, 123);
        assertEquals(po17.area(), a, EPS);
        assertEquals(po17.perimeter(), p, EPS);
        double n = 0.8123;
        po17.scale(Point_2D.ORIGIN, n);
        assertEquals(po17.area(), n*n*a, EPS);
        assertEquals(po17.perimeter(),n*p, EPS);
    }

    @Test
    void testToString() {
        String s3 = po3.toString();
        GeoShape copy_po3 = po3.copy();
        assertEquals(po3, copy_po3);
    }

    @Test
    void perimeter() {
        double p = po4.perimeter(), r2 = Math.sqrt(2);
        assertEquals(p, 4*r2,EPS);
    }

    @Test
    void copy() {
        Polygon_2D copy_po17 = new Polygon_2D( po17);
        po17.equals(copy_po17);
        assertEquals( po17, copy_po17);
        po17.add(Point_2D.ORIGIN);
        assertNotEquals( po17, copy_po17);
    }
    @Test
    public void testArea1() {
        p1 = new Point_2D(-1,0);
        p2 = new Point_2D(0,1);
        p3 = new Point_2D(2,0);
        p4 = new Point_2D(0,-2);
        s1 = new Polygon_2D(); s1.add(p1);s1.add(p2);
        s2 = new Polygon_2D();
        s2.add(p1);s2.add(p2);s2.add(p3);
        s3 = new Polygon_2D();
        s3.add(p1);s3.add(p2);s3.add(p3);s3.add(p4);
        s4 = new Polygon_2D();
        s4.add(p4);s4.add(p3);s4.add(p2);s4.add(p1);

        assertEquals(s1.area(),0,EPS);
        assertEquals(s2.area(),1.5,EPS);
        assertEquals(s3.area(),4.5,EPS);
        assertEquals(s4.area(),4.5,EPS);
    }
    public static Polygon_2D conv_poly(Point_2D cen, int n, double r) {
        Point_2D p = new Point_2D(cen.x()+r, cen.y());
        Polygon_2D ans = new Polygon_2D();
        double ang = 360.0/n;
        for(int i=0;i<n;i=i+1) {
            ans.add(p);
            p.rotate(cen,ang);
        }
        return ans;
    }
}