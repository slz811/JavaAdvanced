package carsalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Map<String, List<Employee>> departmentsList = new LinkedHashMap<>();
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new LinkedList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] line = scanner.nextLine().split("\\s+");
            //"<Model> <Power> <Displacement> <Efficiency>"
            String engineModel = line[0];
            int enginePower = Integer.parseInt(line[1]);

            Engine engine = new Engine(engineModel, enginePower);

            if (line.length > 2) {
                if (isNumeric(line[2])) {
                    engine.setEngineDisplacement(line[2]);
                } else {
                    engine.setEngineEfficiency(line[2]);
                }

                if (line.length > 3) {
                    if (isNumeric(line[3])) {
                        engine.setEngineDisplacement(line[3]);
                    } else {
                        engine.setEngineEfficiency(line[3]);
                    }
                }
            }

            engines.add(engine);
        }


        int m = Integer.parseInt(scanner.nextLine());

        while (m-- > 0) {
            String[] line = scanner.nextLine().split("\\s+");
            //"<Model> <Engine> <Weight> <Color>"
            String carModel = line[0];
            String engineName = line[1];
            Engine engine = null;
            for (Engine e : engines) {
                if (e.getEngineModel().equals(engineName)) {
                    engine = e;
                }
            }

            Car car = new Car(carModel, engine);

            if (line.length > 2) {
                if (isNumeric(line[2])) {
                    car.setCarWeight(line[2]);
                } else {
                    car.setCarColor(line[2]);
                }

                if (line.length > 3) {
                    if (isNumeric(line[3])) {
                        car.setCarWeight(line[3]);
                    } else {
                        car.setCarColor(line[3]);
                    }
                }
            }
            cars.add(car);
        }

        cars.stream().forEach(car -> System.out.println(car.toString()));
    }

    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}