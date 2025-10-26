package Exer_16;
public class ShapeMain {
    public static void main(String[] args) {
        System.out.println("=== SHAPE CALCULATOR ===\n");

        // Create different shapes
        Shape rectangle = new Rectangle(5, 3);
        Shape circle = new Circle(4);
        Shape triangle = new Triangle(3, 4, 5);

        // Display information for each shape
        rectangle.displayInfo();
        circle.displayInfo();
        triangle.displayInfo();

        // Demonstrate polymorphism
        System.out.println("=== POLYMORPHISM DEMO ===");
        Shape[] shapes = {
                new Rectangle(2, 2),
                new Circle(3),
                new Triangle(5, 12, 13)
        };

        for (Shape shape : shapes) {
            shape.displayInfo();
        }
    }
}