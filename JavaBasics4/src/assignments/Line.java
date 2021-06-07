package assignments;

public class Line {
    private double x1, x2, y1, y2, length;

    public Line(double x1, double x2, double y1, double y2, double length) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.length = length;
    }

    public double getSlope() {
        return (y2 - y1) / (x2 - x1);
    }

    public double getDistance() {
        return length;
    }

    public boolean paraellelTo(Line l2) {
        return this.getSlope() == l2.getSlope();
    }
}
