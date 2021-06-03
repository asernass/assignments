package Assignment3;

public class Circle implements Shape {
    private double radius;

    public Circle() {
        this(0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void display() {
        String toPrint = String.format("The area of this Circle is %.3f", calculateArea());
        System.out.println(toPrint);
    }

}
