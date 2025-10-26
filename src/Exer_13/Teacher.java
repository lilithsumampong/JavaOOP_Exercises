package Exer_13;
class Teacher {
    private String name, teacherID, subject;
    private int age;

    Teacher(String name, String teacherID, String subject, int age) {
        this.name = name;
        this.teacherID = teacherID;
        this.subject = subject;
        this.age = age;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public String getSubject() {
        return subject;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}