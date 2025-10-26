package Exer_16;
abstract class Shape {

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public void displayInfo() {
        System.out.println("Area: " + String.format("%.2f", calculateArea()));
        System.out.println("Perimeter: " + String.format("%.2f", calculatePerimeter()));
        System.out.println();
    }
}