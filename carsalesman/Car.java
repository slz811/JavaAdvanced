package carsalesman;


public class Car {
    //A Car has a model, engine, weight and color

    private String carModel;
    private Engine engine;
    private String carWeight;
    private String carColor;

    public Car(String carModel, Engine engine) {
        this.carModel = carModel;
        this.engine = engine;
        this.carWeight = "n/a";
        this.carColor = "n/a";
    }

    public void setCarWeight(String carWeight) {
        this.carWeight = carWeight;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
    //<CarModel>:

    //<EngineModel>:
    //Power: <EnginePower>
    //Displacement: <EngineDisplacement>
    //Efficiency: <EngineEfficiency>

    //Weight: <CarWeight>
    //Color: <CarColor>

    @Override
    public String toString() {
        return String.format("%s: %n%s%nWeight: %s%nColor: %s",
                this.carModel, this.engine, this.carWeight, this.carColor);
    }
}
