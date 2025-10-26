package Exer_3;
public class RectangleMain {

    private double width;
    private double height;

    RectangleMain(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {

        RectangleMain rectangle1 = new RectangleMain(5, 10);

        System.out.println("rectangle1 Area: " + rectangle1.width * rectangle1.height);
        System.out.println("rectangle1 Perimeter: " + 2 * (rectangle1.width + rectangle1.height));
    }
}
