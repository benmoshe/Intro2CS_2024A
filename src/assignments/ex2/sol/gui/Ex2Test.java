package assignments.ex2.sol.gui;
import assignments.ex2.sol.ex2.GUI_Shape_Collection;
import assignments.ex2.sol.geo.Circle_2D;
import assignments.ex2.sol.geo.Point_2D;
import assignments.ex2.sol.geo.Rect_2D;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Ex2Test {

    @Test
    void init() {
        Ex2 ex2 = Ex2.getInstance();
        assertNotNull(ex2);
        GUI_Shape_Collection shapes = ex2.getShape_Collection();
        shapes.removeAll();
        assertNotNull(shapes);
        Point_2D p1 = new Point_2D(3,4);
        Point_2D p2 = new Point_2D(6,8);
        Circle_2D c1 = new Circle_2D(p1,2);
        Rect_2D c2 = new Rect_2D(p2,p1);
        GUI_Shape gs1 = new GUIShape(c1, true, Color.black, 1);
        GUI_Shape gs2 = new GUIShape(c2, true, Color.yellow, 2);
        shapes.add(gs1);
        shapes.add(gs2);
        ex2.init(shapes);
        ex2.show();
        assertEquals(shapes.size(),2);
    }

    @Test
    void getInfo() {
        Ex2 ex2 = Ex2.getInstance();
        assertNotNull(ex2);
        GUI_Shape_Collection shapes = ex2.getShape_Collection();
        shapes.removeAll();
        assertNotNull(shapes);
        Point_2D p1 = new Point_2D(3,4);
        Point_2D p2 = new Point_2D(6,8);
        Circle_2D c1 = new Circle_2D(p1,2);
        Rect_2D c2 = new Rect_2D(p2,p1);
        GUI_Shape gs1 = new GUIShape(c1, true, Color.black, 1);
        GUI_Shape gs2 = new GUIShape(c2, true, Color.yellow, 2);
        shapes.add(gs1);
        shapes.add(gs2);
        String s = ex2.getInfo();
        assertNotNull(s);
    }
}