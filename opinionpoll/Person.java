package opinionpoll;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d",
                this.name, this.age);
    }

    public boolean filterByAge(int age) {
        return this.age > age;
    }

    public String getName() {
        return this.name;
    }
}
