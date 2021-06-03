package Assignment3;

public class test {

    public static void main(String[] args) {
        Circle circle = new Circle(10);
        Rectangle rectangle = new Rectangle(5, 10);
        Triangle triangle = new Triangle(5, 10);

        circle.display(); // 314.159
        rectangle.display(); // 50.0
        triangle.display(); // 25
    }
}
