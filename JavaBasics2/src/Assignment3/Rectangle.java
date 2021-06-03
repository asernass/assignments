package Assignment3;

public class Rectangle implements Shape {
    private int length;
    private int width;

    public Rectangle() {
        this(0, 0);
    }

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public void display() {
        System.out.println("The area of this Retangle is " + calculateArea());
    }

}
