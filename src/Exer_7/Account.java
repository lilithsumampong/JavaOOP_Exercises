package Exer_7;
class Account {
    private String name, job;
    private double balance;

    Account(String name, String job, double balance) {
        this.name = name;
        this.job = job;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "My name is " + name + " I am working as " + job + " my balance is " + balance;
    }
}