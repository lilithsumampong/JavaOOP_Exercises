package Exer_1;

public class PersonMain {

    String name;
    int age;

    PersonMain(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public static void main (String[] args) {

        PersonMain person1 = new PersonMain("Connie", 19);
        PersonMain person2 = new PersonMain("Carl", 15);
        
        System.out.println("I am " + person1.name + " and I am " + person1.age + " years old");
        System.out.println("I am " + person2.name + " and I am " + person2.age + " years old");
    }
}