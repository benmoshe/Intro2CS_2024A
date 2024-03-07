package assignments.ex2.sol.geo;

import assignments.ex2.geo.Point_2D;
import assignments.ex2.geo.Segment_2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Segment_2DTest {

    @Test
    void isIntersect() {
        assignments.ex2.geo.Point_2D p2_2 = new assignments.ex2.geo.Point_2D(2,2);
        assignments.ex2.geo.Point_2D p4_0 = new assignments.ex2.geo.Point_2D(4,0);
        assignments.ex2.geo.Point_2D p0_6 = new assignments.ex2.geo.Point_2D(0,6);
        assignments.ex2.geo.Point_2D p0_3 = new assignments.ex2.geo.Point_2D(0,3);

        assignments.ex2.geo.Segment_2D s1 = new assignments.ex2.geo.Segment_2D(Point_2D.ORIGIN, p2_2);
        assignments.ex2.geo.Segment_2D s2 = new assignments.ex2.geo.Segment_2D(p4_0, p0_6);
        assignments.ex2.geo.Segment_2D s3 = new Segment_2D(p4_0, p0_3);

        assertEquals(s1.isIntersect(s2), false);
        assertEquals(s1.isIntersect(s3), true);

    }
}