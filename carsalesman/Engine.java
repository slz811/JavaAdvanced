package carsalesman;

public class Engine {
    //An Engine has model, power, displacement and efficiency.
    private String engineModel;
    private int enginePower;
    private String engineDisplacement;
    private String engineEfficiency;

    public Engine(String engineModel, int enginePower) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineDisplacement = "n/a";
        this.engineEfficiency = "n/a";
    }

    public void setEngineDisplacement(String engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public void setEngineEfficiency(String engineEfficiency) {
        this.engineEfficiency = engineEfficiency;
    }

    public String getEngineModel() {
        return engineModel;
    }
    //<EngineModel>:
    //Power: <EnginePower>
    //Displacement: <EngineDisplacement>
    //Efficiency: <EngineEfficiency>


    @Override
    public String toString() {
        return String.format("%s: %nPower: %d%nDisplacement: %s%nEfficiency: %s",
                this.engineModel, this.enginePower, this.engineDisplacement, this.engineEfficiency);
    }
}
