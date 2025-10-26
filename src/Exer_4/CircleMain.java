package Exer_4;
public class CircleMain {

    private double radius;

    CircleMain(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public static void main (String[] args) {

        CircleMain circle = new CircleMain(10);

        // Access Radius
        System.out.println("Accessed radius: " + circle.getRadius());

        // Modify Radius
        circle.setRadius(20);
        System.out.println("Modified radius: " + circle.getRadius());

        System.out.printf("Circle Area: %.2f%n" , Math.PI * (circle.radius * circle.radius));
        System.out.printf("Circle Circumference: %.2f%n " , 2 * Math.PI * circle.radius);
    }
}
