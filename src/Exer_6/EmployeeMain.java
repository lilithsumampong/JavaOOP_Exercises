package Exer_6;
public class EmployeeMain {

    private String name;
    private String title;
    private double salary;

    EmployeeMain(String name, String title, double salary) {
        this.name = name;
        this.title = title;
        this.salary = salary;
    }

    public double calculateSalary() {
        return salary * 12;
    }

    public double updateSalary(double percent) {
        double raiseAmount = salary * (percent / 100);
        return salary + raiseAmount;
    }

    public void displayEmployeeInfo() {
        System.out.println("Name: " + name);
        System.out.println("Title: " + title);
        System.out.println("Salary: " + salary);
    }

    public static void main (String[] args) {

        EmployeeMain employee1 = new EmployeeMain(" Lilith Sumampong", "Software Engineer", 10000);

        System.out.println("employee1 Monthly Salary: " + employee1.salary);
        System.out.println("employee1 Annual Salary: " + employee1.calculateSalary());
        System.out.println("employee1 Updated Monthly Salary: " + employee1.updateSalary(10));
        
    }
}
