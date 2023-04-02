package fleet;

public abstract class Vehicle {

    private String make;
    private String model;
    private int year;
    private String color;
    private String VIN;
    private String fuelType;

    public Vehicle(String make, String model, int year, String color, String VIN, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.VIN = VIN;
        this.fuelType = fuelType;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return  "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", VIN='" + VIN + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ',';
    }
}
