package rawdata;

import java.util.HashMap;
import java.util.Map;

public class Car {
    // Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType>
    private String model;
    private int engineSpeed;
    private int enginePower;
    private int engineWeight;
    private String cargoType;
    private Map<Double, Integer> tyres = new HashMap<>(4);

    public Car(String model, int engineSpeed, int enginePower, int engineWeight, String cargoType, Map<Double, Integer> tyres) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.engineWeight = engineWeight;
        this.cargoType = cargoType;
        this.tyres = tyres;
    }

    public String getCargoType() {
        return this.cargoType;
    }


    public boolean maxLimitTyrePressure(int limit) {
        for (Double pressure : this.tyres.keySet()) {
            if (pressure < limit) {
                return true;
            }
        }
        return false;
    }

    public boolean minLimitEnginePower(int limit) {
        if (this.enginePower <= limit) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return String.format("%s", this.model);
    }
}
