package assignments.ex2.sol.ex2;

import assignments.ex2.sol.geo.Circle_2D;
import assignments.ex2.sol.geo.Point_2D;
import assignments.ex2.sol.geo.Rect_2D;
import assignments.ex2.sol.gui.GUIShape;
import assignments.ex2.sol.gui.GUI_Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class Shape_CollectionTest {
    private Shape_Collection _shapes;

    @BeforeEach
    void setUp() {
        _shapes = new Shape_Collection();
        Point_2D p1 = new Point_2D(3, 4);
        Point_2D p2 = new Point_2D(6, 8);
        Circle_2D c1 = new Circle_2D(p1, 2);
        Rect_2D c2 = new Rect_2D(p2, p1);
        GUI_Shape gs1 = new GUIShape(c1, true, Color.black, 1);
        GUI_Shape gs2 = new GUIShape(c2, true, Color.yellow, 2);
        _shapes.add(gs1);
        _shapes.add(gs2);
    }

    @Test
    void size() {
        assertEquals(_shapes.size(), 2);
        _shapes.removeAll();
        assertEquals(_shapes.size(), 0);
    }

    @Test
    void removeElementAt() {
        _shapes.removeElementAt(0);
        assertEquals(_shapes.size(), 1);
        _shapes.removeElementAt(0);
        assertEquals(_shapes.size(), 0);
    }

    @Timeout(1)
    @Test
    void add() {
        _shapes.add(_shapes.get(0));
        assertEquals(_shapes.size(), 3);
        _shapes.add(_shapes.get(1));
        assertEquals(_shapes.size(), 4);
        int n = 1000;
        for (int i = _shapes.size(); i < n; i = i + 1) {
            _shapes.add(_shapes.get(0));
        }
        assertEquals(_shapes.size(), n);
    }

    @Test
    void copy() {
        GUI_Shape_Collection s = _shapes.copy();
        assertEquals(s, _shapes);
        GUI_Shape gs0 = s.get(0);
        gs0.setColor(Color.RED);
        s.add(gs0);;
        assertNotEquals(s, _shapes);
    }

    @Test
    void sort() {
    }

    @Test
    void saveNload() {
        String f= "1.txt";
        GUI_Shape_Collection s = new Shape_Collection();
        _shapes.save(f);
        s.load(f);
        assertEquals(s,_shapes);
    }

    @Test
    void testToString() {
        GUI_Shape_Collection s = new Shape_Collection();
        assertNotEquals(s.toString(), _shapes.toString());
        s = _shapes.copy();
        assertEquals(s.toString(), _shapes.toString());
    }
}