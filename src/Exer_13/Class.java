package Exer_13;
import java.util.HashMap;

class Class {
    private String classID, className, subject, gradeLevel, startTime, endTime;
    private Teacher teacher;
    private HashMap<String, Student> enrolledStudents;

    Class(String classID, String className, String subject, String gradeLevel, String startTime, String endTime) {
        this.classID = classID;
        this.className = className;
        this.subject = subject;
        this.gradeLevel = gradeLevel;
        this.startTime = startTime;
        this.endTime = endTime;

        this.enrolledStudents = new HashMap<>();
        
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.put(student.getStudentID(), student);
    }

    public void removeStudent(Student student) {
        if (enrolledStudents != null) {
            enrolledStudents.remove(student.getStudentID());
        }
    }

    public void displayClassInfo() {
        System.out.println("\nClass ID: " + classID);
        System.out.println("Class Name: " + className);
        System.out.println("Subject: " + subject);
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);
        if (teacher != null) {
            System.out.println("Teacher: " + teacher.getName());
        }
        if (enrolledStudents != null && !enrolledStudents.isEmpty()) {
            System.out.println("Enrolled Students:");
            for (Student student : enrolledStudents.values()) {
                System.out.println("- " + student.getName());
            }
        } else {
            System.out.println("No students enrolled.");
        }
    }


    public String getClassID() {
        return classID;
    }

    public String getClassName() {
        return className;
    }

    public String getSubject() {
        return subject;
    }
    public String getGradeLevel() {
        return gradeLevel;
    }
    public String getStartTime() {
        return startTime;
    }
    public String getEndTime() {
        return endTime;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}