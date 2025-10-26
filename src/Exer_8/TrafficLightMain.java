package Exer_8;
public class TrafficLightMain {

    private String color;
    private int duration;

    public TrafficLightMain(String color, int duration) {
        this.color = color;
        this.duration = duration;
    }

    public void changeToRed() {
        this.color = "Red";
        this.duration = 60;
    }

    public void changeToYellow() {
        this.color = "Yellow";
        this.duration = 5;
    }

    public void changeToGreen() {
        this.color = "Green";
        this.duration = 55;
    }

    public void checkForGreenLight() {
        if (this.color.equals("Green")) {
            System.out.println("The light is green. You can go! for " + this.duration + " seconds.");
        } else {
            System.out.println("The light is not green. Please wait.");
        }
    }

    public void checkForRedLight() {
        if (this.color.equals("Red")) {
            System.out.println("The light is red. Please stop! wait for " + this.duration + " seconds.");
        } else {
            System.out.println("The light is not red. You can proceed with caution.");
        }
    }

    public static void main(String[] args) {
        TrafficLightMain trafficLight = new TrafficLightMain("Red", 60);

        trafficLight.changeToYellow();

        trafficLight.changeToGreen();
        trafficLight.checkForGreenLight();

        trafficLight.changeToRed();
        trafficLight.checkForRedLight();
    }
}
