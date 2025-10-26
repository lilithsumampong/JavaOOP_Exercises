package Exer_13;
class Student {
    private String name, studentID, gradeLevel;
    private int age;

    Student(String name, String studentID, String gradeLevel, int age) {
        this.name = name;
        this.studentID = studentID;
        this.gradeLevel = gradeLevel;
        this.age = age;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public int getAge() {
        return age;
    }
}
