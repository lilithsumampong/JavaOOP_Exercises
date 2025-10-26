package Exer_23;

class Course {
    private String courseName;
    private String instructor;
    private int credits;

    // Constructor
    public Course(String courseName, String instructor, int credits) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.credits = credits;
    }

    // Display course details
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructor);
        System.out.println("Credits: " + credits);
    }

    // Check if course is advanced (more than 3 credits)
    public boolean isAdvancedCourse() {
        return credits > 3;
    }

    // Get course level based on credits
    public String getCourseLevel() {
        if (credits <= 2) {
            return "Introductory";
        } else if (credits <= 4) {
            return "Intermediate";
        } else {
            return "Advanced";
        }
    }

    // Getters
    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getCredits() {
        return credits;
    }

    // Setters with validation
    public void setInstructor(String instructor) {
        if (instructor != null && !instructor.trim().isEmpty()) {
            this.instructor = instructor;
            System.out.println("Instructor updated to: " + instructor);
        } else {
            System.out.println("✗ Instructor name cannot be empty!");
        }
    }

    public void setCredits(int credits) {
        if (credits > 0 && credits <= 6) {
            this.credits = credits;
            System.out.println("Credits updated to: " + credits);
        } else {
            System.out.println("✗ Credits must be between 1 and 6!");
        }
    }
}
