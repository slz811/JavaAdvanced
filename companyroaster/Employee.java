package companyroaster;

public class Employee {
    //: name, salary, position, department, email and age
    String name;
    double salary;
    String position;
    String department;
    String email;
    int age;

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getDepartment() {
        return this.department;
    }


    //Pesho 120.00 pesho@abv.bg 28


    @Override
    public String toString() {
        return String.format("%s %.2f %s %d",
                this.name, this.salary, this.email, this.age);
    }
}
