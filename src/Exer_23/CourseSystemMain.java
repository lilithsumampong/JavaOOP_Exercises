package Exer_23;


// Main class to test the course system
public class CourseSystemMain {
    public static void main(String[] args) {
        System.out.println("=== COURSE MANAGEMENT SYSTEM ===\n");

        // Create regular courses
        System.out.println("--- Creating Regular Courses ---");
        Course mathCourse = new Course("Calculus I", "Dr. Johnson", 4);
        Course historyCourse = new Course("World History", "Prof. Davis", 3);

        // Create online courses
        System.out.println("\n--- Creating Online Courses ---");
        OnlineCourse javaCourse = new OnlineCourse("Java Programming", "Dr. Smith", 4,
                "Coursera", 8, true);
        OnlineCourse pythonCourse = new OnlineCourse("Python Basics", "Prof. Wilson", 2,
                "Udemy", 3, true);
        OnlineCourse webCourse = new OnlineCourse("Web Development", "Ms. Garcia", 3,
                "edX", 6, false);
        OnlineCourse selfPacedCourse = new OnlineCourse("Data Science", "Dr. Brown", 5,
                "Pluralsight", 16, true);

        // Display regular course details
        System.out.println("\n--- Regular Course Details ---");
        mathCourse.displayCourseDetails();
        System.out.println("\n" + "=".repeat(40));
        historyCourse.displayCourseDetails();

        // Display online course details
        System.out.println("\n--- Online Course Details ---");
        javaCourse.displayCourseDetails();
        System.out.println("\n" + "=".repeat(40));
        pythonCourse.displayCourseDetails();
        System.out.println("\n" + "=".repeat(40));
        webCourse.displayCourseDetails();
        System.out.println("\n" + "=".repeat(40));
        selfPacedCourse.displayCourseDetails();

        // Test certificate eligibility
        System.out.println("\n=== CERTIFICATE ELIGIBILITY CHECK ===");
        System.out
                .println("Java Programming: " + (javaCourse.isEligibleForCertificate() ? "Eligible" : "Not Eligible"));
        System.out.println("Python Basics: " + (pythonCourse.isEligibleForCertificate() ? "Eligible" : "Not Eligible"));
        System.out.println("Web Development: " + (webCourse.isEligibleForCertificate() ? "Eligible" : "Not Eligible"));
        System.out
                .println("Data Science: " + (selfPacedCourse.isEligibleForCertificate() ? "Eligible" : "Not Eligible"));

        // Generate study plans
        System.out.println("\n=== STUDY PLANS ===");
        javaCourse.generateStudyPlan();
        System.out.println("\n" + "-".repeat(30));
        pythonCourse.generateStudyPlan();

        // Test course modifications
        System.out.println("\n=== TESTING COURSE MODIFICATIONS ===");
        pythonCourse.setDuration(6); // Make Python course eligible for certificate
        pythonCourse.displayCourseDetails();

        webCourse.setCertificateOption(true); // Enable certificate for web course
        webCourse.displayCourseDetails();

        // Test error handling
        System.out.println("\n=== TESTING ERROR HANDLING ===");
        mathCourse.setCredits(0); // Invalid credits
        mathCourse.setCredits(4); // Valid credits
        pythonCourse.setDuration(60); // Invalid duration

        // Test self-paced detection
        System.out.println("\n=== SELF-PACED COURSE CHECK ===");
        System.out.println("Java Programming self-paced: " + javaCourse.isSelfPaced());
        System.out.println("Data Science self-paced: " + selfPacedCourse.isSelfPaced());

        // Demonstrate polymorphism
        System.out.println("\n=== POLYMORPHISM DEMONSTRATION ===");
        Course[] courses = {
                new Course("Physics I", "Dr. Lee", 4),
                new OnlineCourse("Machine Learning", "Dr. Patel", 5, "Coursera", 10, true),
                new Course("Chemistry", "Prof. Clark", 3),
                new OnlineCourse("Mobile App Development", "Ms. Taylor", 4, "Udacity", 8, true)
        };

        for (Course course : courses) {
            course.displayCourseDetails();

            // Check if it's an online course to access online-specific methods
            if (course instanceof OnlineCourse) {
                OnlineCourse onlineCourse = (OnlineCourse) course;
                System.out.println("Certificate Eligible: " + onlineCourse.isEligibleForCertificate());
                System.out.println("Self-Paced: " + onlineCourse.isSelfPaced());
            }
            System.out.println("\n" + "=".repeat(50));
        }

        // Final summary
        System.out.println("=== COURSE CATALOG SUMMARY ===");
        System.out.println("Regular Courses: Calculus I, World History, Physics I, Chemistry");
        System.out.println("Online Courses: Java Programming, Python Basics, Web Development, " +
                "Data Science, Machine Learning, Mobile App Development");
        System.out.println("Platforms used: Coursera, Udemy, edX, Pluralsight, Udacity");
    }
}