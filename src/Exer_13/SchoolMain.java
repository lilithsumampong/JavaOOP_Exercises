package Exer_13;
import java.util.HashMap;

public class SchoolMain {

    private HashMap<String, Student> students;
    private HashMap<String, Teacher> teachers;
    private HashMap<String, Class> classes;

    SchoolMain() {
        students = new HashMap<>();
        teachers = new HashMap<>();
        classes = new HashMap<>();
    }

    // methods
    public void addStudent(Student student) {
        if (students.containsKey(student.getStudentID())) {
            System.out.println("\nThis student already exists!");
        } else {
            students.put(student.getStudentID(), student);
            System.out.println("Student " + student.getStudentID() + " successfully added!");
        }
    }

    public void removeStudent(Student student) {
        if (students.containsKey(student.getStudentID())) {
            students.remove(student.getStudentID());
            System.out.println("\nStudent " + student.getStudentID() + " successfully removed!");
        } else {
            System.out.println("\nThis student does not exist!");
        }
    }

    public void addTeacher(Teacher teacher) {
        if (teachers.containsKey(teacher.getTeacherID())) {
            System.out.println("\nThis teacher already exists!");
        } else {
            teachers.put(teacher.getTeacherID(), teacher);
            System.out.println("Teacher " + teacher.getTeacherID() + " successfully added!");
        }
    }

    public void removeTeacher(Teacher teacher) {
        if (teachers.containsKey(teacher.getTeacherID())) {
            teachers.remove(teacher.getTeacherID());
            System.out.println("\nTeacher " + teacher.getTeacherID() + " successfully removed!");
        } else {
            System.out.println("\nThis teacher does not exist!");
        }
    }

    public void addClass(Class cls) {
        if (classes.containsKey(cls.getClassID())) {
            System.out.println("\nThis class already exists!");
        } else {
            classes.put(cls.getClassID(), cls);
            System.out.println("Class " + cls.getClassID() + " successfully created!");
        }
    }

    public void assignTeacherToClass(Class cls, Teacher teacher) {
        if (cls.getTeacher() != null) {
            System.out.println("This class already has assigned teacher its " + cls.getTeacher());
        } else
            cls.assignTeacher(teacher);
        System.out.println(cls.getTeacher().getName() + " successfully assigned on class " + cls.getClassID());
    }

    public void enrollStudentInClass(Class cls, Student student) {
        cls.enrollStudent(student);
    }

    public static void main(String[] args) {

        SchoolMain school = new SchoolMain();

        Student student1 = new Student("Connie Dee", "S001", "10th Grade", 15);
        Student student2 = new Student("Aries Mark", "S002", "9th Grade", 14);
        Student student3 = new Student("Lean Mark", "S003", "8th Grade", 13);

        Teacher teacher1 = new Teacher("Mr. Smith", "T001", "English", 40);

        Class class1 = new Class("C001", "Eng-10-A", "English", "Grade-10", "09:00 AM", "10:30 AM");

        school.addClass(class1);
        school.assignTeacherToClass(class1, teacher1);

        class1.displayClassInfo();

        school.enrollStudentInClass(class1, student1);
        school.enrollStudentInClass(class1, student2);
        school.enrollStudentInClass(class1, student3);

        System.out.println("\nUpdated class1:");
        class1.displayClassInfo();

    }
}
