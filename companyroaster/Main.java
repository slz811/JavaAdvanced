package companyroaster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Employee>> departmentsList = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] line = scanner.nextLine().split("\\s+");
            String name = line[0];
            double salary = Double.parseDouble(line[1]);
            String position = line[2];
            String department = line[3];

            Employee person = new Employee(name, salary, position, department);

            if (line.length > 4) {
                String email = line[4];
                if (!isNumeric(email)) {
                    person.setEmail(email);
                } else {
                    person.setAge(Integer.parseInt(email));
                }
                if (line.length > 5) {
                    int age = Integer.parseInt(line[5]);
                    person.setAge(age);

                }
            }

            departmentsList.putIfAbsent(department, new ArrayList<>());
            departmentsList.get(department).add(person);
        }

        String highestSalaryDepartment = getHighestSalaryDepartment(departmentsList);

        System.out.printf("Highest Average Salary: %s%n", getHighestSalaryDepartment(departmentsList));

        departmentsList.get(highestSalaryDepartment)
                .stream()
                .sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));

    }

    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    private static String getHighestSalaryDepartment(Map<String, List<Employee>> departmentsList) {
        String bestDepartment = "";

        double average = 0;
        for (String department : departmentsList.keySet()) {

            double sum = 0;
            int count = 0;
            for (Employee employee : departmentsList.get(department)) {

                sum += employee.getSalary();
                count = departmentsList.get(department).size();
            }
            double current = sum / count;
            if (average < current) {
                average = current;
                bestDepartment = department;
            }

        }
        return bestDepartment;
    }
}