package fleet;

public class Truck extends Vehicle {

    private double maxLoad;

    public Truck(String make, String model, int year, String color, String VIN, String fuelType, double maxLoad) {
        super(make, model, year, color, VIN, fuelType);
        this.maxLoad = maxLoad;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    @Override
    public String toString() {
        return "Truck{" + super.toString() +
                "maxLoad=" + maxLoad +
                '}';
    }
}
