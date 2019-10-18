package rawdata;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new LinkedList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] line = scanner.nextLine().split("\\s+");
            String model = line[0];
            int engineSpeed = Integer.parseInt(line[1]);
            int enginePower = Integer.parseInt(line[2]);
            int engineWeight = Integer.parseInt(line[3]);
            String cargoType = line[4];

            Map<Double, Integer> tyres = new HashMap<>(4);
            for (int i = 5; i < line.length; i += 2) {
                double pressure = Double.parseDouble(line[i]);
                int age = Integer.parseInt(line[i + 1]);
                tyres.put(pressure, age);
            }

            Car car = new Car(model, engineSpeed, enginePower, engineWeight, cargoType, tyres);

            cars.add(car);

        }

        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            for (Car car : cars) {
                if (car.getCargoType().equals(command) && car.maxLimitTyrePressure(1)) {
                    System.out.println(car.toString());
                }
            }
        } else {
            for (Car car : cars) {
                if (car.getCargoType().equals(command) && car.minLimitEnginePower(250)) {
                    System.out.println(car.toString());
                }
            }
        }
    }

    private static List<Car> filteredCars(List<Car> cars, String command) {
        List<Car> filtered = new ArrayList<>();

        cars.stream().forEach(car -> {
            if (command.equals(car.getCargoType())) {
                filtered.add(car);
            }
        });
        return filtered;
    }

}