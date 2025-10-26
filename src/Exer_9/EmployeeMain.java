package Exer_9;
public class EmployeeMain {

    private String name;
    private double salary;
    private int hiredDate;

    EmployeeMain(String name, double salary, int hiredDate) {
        this.name = name;
        this.salary = salary;
        this.hiredDate = hiredDate;
    }

    public double annualSalary() {
        return salary * 12;
    }

    public int yearOfService(int currentYear) {
        return currentYear - hiredDate;
    }

    public String getName() {
        return name;
    }

    public static void main (String[] args) {
        
        EmployeeMain employee1 = new EmployeeMain("Connie Manguiran", 5000, 2015);

        System.out.println("employee1   Monthly Salary: " + employee1.salary);
        System.out.println("employee1 Annual Salary: " + employee1.annualSalary());

        System.out.println("employee1 Years of Service: " + employee1.yearOfService(2025));


        
    }
}
