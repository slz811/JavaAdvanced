package google;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();


        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");

            String personName = tokens[0];
            people.putIfAbsent(personName, new Person(personName));

            if (line.contains("company")) {
                String name = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);
                Company company = new Company();
                company.setName(name);
                company.setDepartment(department);
                company.setSalary(salary);

                people.get(personName).setCompany(company);
            } else if (line.contains("car")) {
                String model = tokens[2];
                int speed = Integer.parseInt(tokens[3]);
                Car car = new Car();
                car.setModel(model);
                car.setSpeed(speed);
                people.get(personName).setCar(car);
            } else if (line.contains("pokemon")) {
                String name = tokens[2];
                String type = tokens[3];
                Pokemon pokemon = new Pokemon(name, type);
                people.get(personName).addPokemons(pokemon);
            } else if (line.contains("parents")) {
                String name = tokens[2];
                String birthDate = tokens[3];
                Parent parent = new Parent(name, birthDate);
                people.get(personName).addParents(parent);
            } else if (line.contains("children")) {
                String name = tokens[2];
                String birthDate = tokens[3];
                Child child = new Child(name, birthDate);
                people.get(personName).addChildren(child);
            }


            line = scanner.nextLine();
        }

        String nameToPrint = scanner.nextLine();

        if (people.containsKey(nameToPrint)) {
            String s = people.get(nameToPrint).toString();
            System.out.println(s);
        }


    }
}