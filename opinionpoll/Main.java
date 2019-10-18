package opinionpoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] line = scanner.nextLine().split("\\s+");
            String name = line[0];
            int age = Integer.parseInt(line[1]);

            Person person = new Person(name, age);

            people.add(person);

        }

        people.stream()
                .filter(person -> person.filterByAge(30))
                .sorted((f, s) -> f.getName().compareTo(s.getName()))
                .forEach(person -> System.out.println(person.toString()));
    }
}