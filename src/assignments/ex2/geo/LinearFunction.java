package assignments.ex2.geo;

/**
 * This class represents a simple
 * linear function of form f(x) = a*x+b
 */
public class LinearFunction {
    private double a,b;
    public LinearFunction(double a1, double b1) {
        a= a1; b = b1;
    }
    public LinearFunction(Point_2D p1, Point_2D p2) {
        double dx = p2.x()-p1.x();
        double dy = p2.y()-p1.y();
        a = dy/dx;
        b = p1.y() - a*p1.x();
    }
    public double f(double x) {return x*a+b;}
    public Point_2D fp(double x) {
        return new Point_2D(x, f(x));
    }
    public Point_2D intersect(LinearFunction ot) {
        Point_2D ans = null;
        if(this.getShipuaa() != ot.getShipuaa()) {
            // f(x) = a*x+b == g(x) = a1*x+b1;
            //x(a-a1) = b1-b;
            // x = (b1-b)/(a-a1)
            double b1 = ot.b;
            double a1 = ot.getShipuaa();
            double x = (b1-b)/(a-a1);
            ans = new Point_2D(x,f(x));
        }
        return ans;
    }
    public double getShipuaa() {return a;}
}
