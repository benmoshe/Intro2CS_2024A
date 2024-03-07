package assignments.ex2.sol.geo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static assignments.ex2.sol.ex2.Ex2_Const.EPS;
import static org.junit.jupiter.api.Assertions.*;

class Point_2DTest {
    private Point_2D p1_2 = null;

    private Point_2D p4_6 = null;//
    @BeforeEach
    public void setup() {
        p1_2 = new Point_2D(1,2);
        p4_6 = new Point_2D(4,6);
    }


    @Test
    void add() {
        Point_2D p = p1_2.add(p4_6);  // (5,8)
        Point_2D pp = new Point_2D(5,8);
        double d = p.distance(pp);
        assertTrue(d<EPS);
        assertEquals(p,pp);
    }

    @Test
    void testToString() {
        String s12 = p1_2.toString();
        Point_2D p12 = new Point_2D(s12);
        assertEquals(p12,p1_2);
    }

    @Test
    void distance() {

    }

    @Test
    void testDistance() {
        double d = p1_2.distance(p4_6);
        assertEquals(d,5,EPS);
    }

    @Test
    void vector() {
        Point_2D v = p1_2.vector(p4_6);
        Point_2D v2 = new Point_2D(p4_6.x()-p1_2.x(), p4_6.y()-p1_2.y());
        assertEquals(v.distance(),5);
        assertEquals(v, v2);
    }

    @Test
    void move() {
        Point_2D p12a = new Point_2D(p1_2);
        Point_2D p12b = new Point_2D(p1_2);
        p12a.rotate(p4_6,180);
        Point_2D v = p1_2.vector(p4_6);
        p12b.move(v);
        p12b.move(v);
        assertEquals(p12a,p12b);
    }

    @Test
    void scale() {
        Point_2D p = new Point_2D(p1_2);
        p.scale(Point_2D.ORIGIN,0.5); // p(0.5,1);
        Point_2D t = new Point_2D(0.5,1);
        assertEquals(p,t);
    }
    @Test
    void scale2() {
        Point_2D p = new Point_2D(p1_2);
        p.scale(Point_2D.ORIGIN,2); // p(0.5,1);
        Point_2D t = new Point_2D(2,4);
        assertEquals(p,t);
    }
    @Test
    void scale3() {
        Point_2D p = new Point_2D(p1_2);
        p.scale(Point_2D.ORIGIN,-0.5); // p(0.5,1);
        Point_2D t = new Point_2D(-0.5,-1);
        assertEquals(p,t);
    }
    @Test
    void scale5() {
        Point_2D p = new Point_2D(p4_6);
        p.scale(p1_2,0.5); // p(2.5,4);
        Point_2D t = new Point_2D(2.5,4);
        assertEquals(p,t);
    }

    @Test
    void rotate() {
        Point_2D p = new Point_2D(p1_2);
        double d1 = p.distance();
        p.rotate(Point_2D.ORIGIN, 10);
        double d2 = p.distance();
        assertEquals(d1,d2,EPS);
        assertNotEquals(p1_2,p);
        p.rotate(Point_2D.ORIGIN, -10);
        assertTrue(p1_2.close2equals(p,EPS));
    }
}