package assignments.ex2.sol.gui;


import assignments.ex2.sol.geo.Circle_2D;
import assignments.ex2.sol.geo.Point_2D;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GUIShapeTest {
    private Point_2D p1 = new Point_2D(3, 4);
    private Circle_2D c1 = new Circle_2D(p1, 5);
    private GUIShape gy = new GUIShape(c1, true, Color.yellow, 1);

public static int colorEncoding(Color c) {
    int r = c.getRed();
    int b = c.getBlue();
    int g = c.getGreen();
    int ce = r*256*256 + g*256 + b;
    return ce;
}
    @Test
    void getColor() {
        Color ye = Color.yellow, bl = Color.black;
        Color red = Color.red, gr = Color.green;
        int ce = colorEncoding(ye);
        System.out.println("Color "+ye.toString()+", Encoding: "+ce);// 16776960
        System.out.println("Color "+bl.toString()+", Encoding: "+colorEncoding(bl));
    }

    @Test
    void copy() {
        GUI_Shape g2 = new GUIShape(gy);
        assertEquals(gy,g2);
    }

    @Test
    void testToString() {
        String s = gy.toString();
        GUI_Shape g2 = new GUIShape(s);
        assertEquals(gy,g2);
    }
}