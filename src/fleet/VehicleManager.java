package fleet;

import java.util.List;

public interface VehicleManager {

    void addVehicle (Vehicle vehicle) throws DuplicateVehicleException;

    List<Vehicle> searchVehiclesByMake(String make);

    List<Vehicle> searchVehicleByModel(String model);

    List<Vehicle> getAllVehicles();

    void removeVehicle (String VIN) throws NoSuchVehicleException;

}
