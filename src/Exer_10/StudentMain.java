package Exer_10;
import java.util.ArrayList;

public class StudentMain {
    private String name;
    private double grade;
    private ArrayList<String> courses;

    StudentMain(String name, double grade) {
        this.name = name;
        this.grade = grade;
        this.courses = new ArrayList<>();
    }

    public void addCourse(String course) {
        if(courses.contains(course)) {
            System.out.println("This course " + course + " is already enrolled on you!");
        } else {
            courses.add(course);
            System.out.println("course " + course + " successfully added");
        }
    }

    public void removeCourse(String course) {
        if (!courses.contains(course)) {
            System.out.println("this course " + course + " is not on your lists!");
        } else {
            courses.remove(course);
            System.out.println("course " + course + " successfully removed!");
        }
    }

    public void displayInfo() {
        System.out.println("name: " + name);
        System.out.println("grade: " + grade);
        System.out.println("courses: " + courses);
    }

    public static void main (String[] args) {

        StudentMain student1 = new StudentMain("Connie", 99);
        
        student1.addCourse("BSIT");

        // display info
        student1.displayInfo();

        student1.removeCourse("BSIT");

        student1.displayInfo();

    }

    
}