package fleet;

public class Car extends Vehicle{

    private int doors;
    private String bodyType;

    public Car(String make, String model, int year, String color, String VIN, String fuelType, int doors, String bodyType) {
        super(make, model, year, color, VIN, fuelType);
        this.doors = doors;
        this.bodyType = bodyType;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "Car{" + super.toString() +
                "doors=" + doors +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }
}
