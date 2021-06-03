package Assignment3;

public class Triangle implements Shape {
    private int base;
    private int height;

    public Triangle() {
        this(0, 0);
    }

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return (1.0 / 2) * base * height;
    }

    @Override
    public void display() {
        String toPrint = String.format("The area of this Triangle is %.3f", calculateArea());
        System.out.println(toPrint);
    }

}
