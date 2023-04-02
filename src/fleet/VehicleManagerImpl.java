package fleet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VehicleManagerImpl implements VehicleManager {

    private List<Vehicle> vehicles;

    public VehicleManagerImpl() {
        this.vehicles = new ArrayList<>();
    }


    @Override
    public void addVehicle(Vehicle vehicle) throws DuplicateVehicleException {

        for (Vehicle v : vehicles) {
            if (v.getVIN().equals(vehicle.getVIN())) {
                throw new DuplicateVehicleException("Vozilo s istom VIN oznakom već postoji u floti.");
            }
        }

        vehicles.add(vehicle);

    }

    @Override
    public List<Vehicle> searchVehiclesByMake(String make) {
        List<Vehicle> result = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMake().equals(make)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    @Override
    public List<Vehicle> searchVehicleByModel(String model) {
        List<Vehicle> result = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getModel().equals(model)) {
                result.add(vehicle);
            }
        }

        return result;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
        return null;
    }

    @Override
    public void removeVehicle(String VIN) throws NoSuchVehicleException {
        Iterator<Vehicle> iterator = vehicles.iterator();

        while (iterator.hasNext()) {
            Vehicle vehicle = iterator.next();
            if (vehicle.getVIN().equals(VIN)) {
                iterator.remove();
                return;
            }
        }
        throw new NoSuchVehicleException("Pokušali ste obrisati vozilo koje ne postoji sa VIN brojem " + VIN);
    }
}








//    private ArrayList<Car> carList;
//    private ArrayList<Truck> truckList;
//
//    public Inputs() {
//        carList = new ArrayList<>();
//        truckList = new ArrayList<>();
//    }
//
//    public void addCar (Car car) throws DuplicateVehicleException {
//        String newVIN = car.getVIN();
//        boolean existingVin = false;
//        for (Car c : carList) {
//            if (c.getVIN().equals(String.valueOf(Integer.parseInt(newVIN)))) {
//                existingVin = true;
//                break;
//            }
//        }
//        if (existingVin) {
//            throw new DuplicateVehicleException("Vozilo s istom VIN oznakom već postoji u floti.");
//        } else {
//            carList.add(car);
//        }
//    }
//
//    public Car searchCar (String carKeyWord) {
//        List<Car> searchResult;
//        searchResult = new ArrayList<>();
//        for (Car car : carList) {
//            if (car.getModel().toLowerCase().contains(carKeyWord.toLowerCase()) ||
//            car.getMake().toLowerCase().contains(carKeyWord.toLowerCase()) ||
//            car.getVIN().toLowerCase().contains(carKeyWord.toLowerCase())){
//            searchResult.add(car);
//            }
//        }
//        return (Car) searchResult;
//    }
//
//    public void printAllCars() {
//        for (Car car : carList) {
//            System.out.println(carList);
//        }
//    }
//
//    public void removeCar(String VIN) throws NoSuchVehicleException {
//        boolean removed = carList.removeIf(car -> car.getVIN().equals(VIN));
//        if (!removed) {
//            throw new NoSuchVehicleException("Automobil sa oznakom VIN " + VIN + " ne postoji u floti.");
//        }
//    }
//
//    public void addTruck (Truck truck) {
//        truckList.add(truck);
//    }
//
//    public Truck searchTruck (String truckKeyWord) {
//        List<Truck> searchResult;
//        searchResult = new ArrayList<>();
//        for (Truck truck : truckList) {
//            if (truck.getModel().toLowerCase().contains(truckKeyWord.toLowerCase()) ||
//                    truck.getMake().toLowerCase().contains(truckKeyWord.toLowerCase()) ||
//                    truck.getVIN().toLowerCase().contains(truckKeyWord.toLowerCase())){
//                searchResult.add(truck);
//            }
//        }
//        return (Truck) searchResult;
//    }
//
//    public void printAllTruck() {
//        for (Truck truck : truckList) {
//            System.out.println(truckList);
//        }
//    }
//
//    public void removeTruck(String VIN) throws NoSuchVehicleException {
//        boolean removed = truckList.removeIf(truck -> truck.getVIN().equals(VIN));
//        if (!removed){
//            throw new NoSuchVehicleException("Kamion sa oznakom VIN " + VIN + " ne postoji u floti.");
//        }
//    }
//
//}
