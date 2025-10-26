package Exer_23;

class OnlineCourse extends Course {
    private String platform;
    private int duration; // in weeks
    private boolean hasCertificate;

    // Constructor
    public OnlineCourse(String courseName, String instructor, int credits,
            String platform, int duration, boolean hasCertificate) {
        super(courseName, instructor, credits); // Call parent constructor
        this.platform = platform;
        this.duration = duration;
        this.hasCertificate = hasCertificate;
    }

    // Check if course is eligible for certificate
    public boolean isEligibleForCertificate() {
        // Certificate eligibility: course must be at least 4 weeks and have certificate
        // option
        return duration >= 4 && hasCertificate;
    }

    // Calculate estimated study hours per week
    public double getWeeklyStudyHours() {
        // Typically 3 hours per credit per week
        return getCredits() * 3.0;
    }

    // Calculate total study hours for entire course
    public double getTotalStudyHours() {
        return getWeeklyStudyHours() * duration;
    }

    // Get platform
    public String getPlatform() {
        return platform;
    }

    // Get duration
    public int getDuration() {
        return duration;
    }

    // Check if has certificate option
    public boolean hasCertificateOption() {
        return hasCertificate;
    }

    // Set certificate option
    public void setCertificateOption(boolean hasCertificate) {
        this.hasCertificate = hasCertificate;
        System.out.println("Certificate option " + (hasCertificate ? "enabled" : "disabled"));
    }

    // Set duration
    public void setDuration(int duration) {
        if (duration > 0 && duration <= 52) { // Max 1 year
            this.duration = duration;
            System.out.println("Duration updated to: " + duration + " weeks");
        } else {
            System.out.println("✗ Duration must be between 1 and 52 weeks!");
        }
    }

    // Override displayCourseDetails to show online course specific information
    @Override
    public void displayCourseDetails() {
        System.out.println("\n=== ONLINE COURSE DETAILS ===");
        super.displayCourseDetails(); // Call parent's display method
        System.out.println("Platform: " + platform);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Certificate Option: " + (hasCertificate ? "Yes" : "No"));
        System.out.println("Weekly Study Hours: " + getWeeklyStudyHours() + " hours");
        System.out.println("Total Study Hours: " + getTotalStudyHours() + " hours");
        System.out.println("Course Level: " + getCourseLevel());
        System.out.println("Advanced Course: " + (isAdvancedCourse() ? "Yes" : "No"));
        System.out.println("Eligible for Certificate: " + (isEligibleForCertificate() ? "Yes" : "No"));

        // Additional certificate information
        if (hasCertificate && !isEligibleForCertificate()) {
            System.out.println("ℹ️  Note: Course has certificate option but duration is too short (" +
                    duration + " weeks). Minimum 4 weeks required.");
        }
    }

    // Online course specific method - generate study plan
    public void generateStudyPlan() {
        System.out.println("\n--- STUDY PLAN FOR " + getCourseName().toUpperCase() + " ---");
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Weekly commitment: " + getWeeklyStudyHours() + " hours");
        System.out.println("Total commitment: " + getTotalStudyHours() + " hours");
        System.out.println("Platform: " + platform);

        if (isEligibleForCertificate()) {
            System.out.println("✓ Certificate available upon completion");
        }
    }

    // Check if course is self-paced (long duration suggests self-paced)
    public boolean isSelfPaced() {
        return duration > 12; // Courses longer than 12 weeks are typically self-paced
    }
}
