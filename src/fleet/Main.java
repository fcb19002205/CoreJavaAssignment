package fleet;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VehicleManager vehicleManager = new VehicleManagerImpl();

        Logger LOGGER = Logger.getLogger(Main.class.getName());
        try {
            FileHandler fileHandler = new FileHandler("log.txt");
            LOGGER.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            LOGGER.warning("Log datoteka se nije uspjela kreirati: " + e.getMessage());
        }

        while (true) {
            System.out.println();
            System.out.println("Vehicle Fleet Managament System");
            System.out.println("-------------------------------");
            System.out.println("1 - Dodavanje vozila u flotu");
            System.out.println("2 - Pretraga vozila po marki ili modelu");
            System.out.println("3 - Ispis svih vozila u floti");
            System.out.println("4 - Brisanje vozila iz flote");
            System.out.println("5 - Kraj");
            System.out.println();
            System.out.print("Opcija: ");


            String option = scanner.next();

            switch (option) {
                case "1":
                    System.out.println("Koji tip vozila želite dodati?");
                    boolean vehicleType = true;
                    while (vehicleType) {
                        System.out.println("Unesite 'automobil' ili 'kamion': ");
                        String typeOfVehicle = scanner.next().toLowerCase();
                        switch (typeOfVehicle) {
                            case "automobil":
                                System.out.print("Unesite proizvođača automobila: ");
                                String carMake = scanner.next();
                                System.out.print("Unesite model automobila: ");
                                String carModel = scanner.next();
                                System.out.print("Unesite godinu proizvodje automobila: ");
                                int carYear = scanner.nextInt();
                                System.out.print("Unesite boju automobila: ");
                                String carColor = scanner.next();
                                System.out.print("Unesite VIN automobila: ");
                                String carVIN = String.valueOf(Integer.parseInt(scanner.next()));
                                System.out.print("Unesite vrstu goriva koju automobil koristi: ");
                                String carFuelType = scanner.next();
                                System.out.print("Unesite broj vrata automobila: ");
                                int carNumberOfDoors = scanner.nextInt();
                                System.out.print("Unesite vrstu vozila: ");
                                String carBodyStyle = scanner.next();

                                Vehicle newCar = new Car(carMake, carModel, carYear, carColor, carVIN, carFuelType, carNumberOfDoors, carBodyStyle);
                                try {
                                    vehicleManager.addVehicle(newCar);
                                    System.out.print("Vozilo uspješno dodano.");
                                    System.out.println();
                                    LOGGER.info("Vozilo uspješno dodano");
                                } catch (DuplicateVehicleException e) {
                                    System.err.println(e.getMessage());
                                    LOGGER.warning("Vozilo nije unesešno, greška pri unosu.");
                                }
                                vehicleType = false;
                                break;

                            case "kamion":
                                System.out.print("Unesite proizvođača kamiona: ");
                                String truckMake = scanner.next();
                                System.out.print("Unesite model kamiona: ");
                                String truckModel = scanner.next();
                                System.out.print("Unesite godinu proizvodnje kamiona: ");
                                int truckYear = scanner.nextInt();
                                System.out.print("Unesite boju kamiona: ");
                                String truckColor = scanner.next();
                                System.out.print("Unesite VIN kamiona: ");
                                String truckVIN = String.valueOf(Integer.parseInt(scanner.next()));
                                System.out.print("Unesite vrstu goriva koju kamion koristi: ");
                                String truckFuelType = scanner.next();
                                System.out.print("Unesite kapacitet tereta: ");
                                double truckCapacity = Double.parseDouble(scanner.next());

                                Vehicle newTruck = new Truck(truckMake, truckModel, truckYear, truckColor, truckVIN, truckFuelType, truckCapacity);
                                try {
                                    vehicleManager.addVehicle(newTruck);
                                    System.out.print("Vozilo uspješno dodano.");
                                    System.out.println();
                                    LOGGER.info("Vozilo uspješno dodano.");
                                } catch (DuplicateVehicleException e) {
                                    System.err.println(e.getMessage());
                                    LOGGER.warning("Vozilo nije unešeno, greška pri unosu.");
                                }
                                vehicleType = false;
                                break;

                            default:
                                System.out.println();
                                System.out.println("Unijeli ste krivu opciju.");
                        }

                    }
                    break;


                case "2":
                    System.out.println("Birajte na koji način želite pretražiti vozila: ");
                    boolean search = true;
                    while (search) {
                        System.out.println("1 - Pretraži po proizvođaču");
                        System.out.println("2 - Pretraži po modelu");
                        System.out.println("Opcija: ");
                        String typeOfSearch = scanner.next();

                        switch (typeOfSearch) {
                            case "1":
                                System.out.println("Unesite proizvođača: ");
                                String manufacturer = scanner.next();

                                List<Vehicle> searchVehicleByMake = vehicleManager.searchVehiclesByMake(manufacturer);

                                if (searchVehicleByMake.isEmpty()) {
                                    System.out.println("Nije pronađeno vozilo marke: " + manufacturer);
                                }

                                for (Vehicle vehicle : searchVehicleByMake) {
                                    if (vehicle instanceof Car) {
                                        Car car = (Car) vehicle;
                                        System.out.println(car);
                                    } else if (vehicle instanceof Truck) {
                                        Truck truck = (Truck) vehicle;
                                        System.out.println(truck);
                                    }
                                }
                                LOGGER.info("Izvršeno pretraživanje po proizvođaču.");
                                search = false;
                                break;
                            case "2":
                                System.out.println("Unesite model: ");
                                String model = scanner.next();

                                List<Vehicle> searchVehicleByModel = vehicleManager.searchVehicleByModel(model);

                                if (searchVehicleByModel.isEmpty()) {
                                    System.out.println("Nije pronađen model vozila: " + model);
                                }

                                for (Vehicle vehicle : searchVehicleByModel) {
                                    if (vehicle instanceof Car) {
                                        Car car = (Car) vehicle;
                                        System.out.println(car);
                                    } else if (vehicle instanceof Truck) {
                                        Truck truck = (Truck) vehicle;
                                        System.out.println(truck);
                                    }
                                }
                                LOGGER.info("Izvršeno pretraživanje po modelu.");
                                search = false;
                                break;

                            default:
                                System.out.println("Odabrali ste nepostojeću opciju, molimo odaberite 1 ili 2.");
                        }
                    }
                    break;

                case "3":
                    System.out.println("Ispis svih automobila u floti: ");
                    vehicleManager.getAllVehicles();
                    LOGGER.info("Ispis popisa automobila obavljen.");
                    break;


                case "4":
                    System.out.println("Unesite VIN oznaku za brisanje vozila: ");
                    String removeVehicleByVIN = scanner.next();

                    try {
                        vehicleManager.removeVehicle(removeVehicleByVIN);
                        System.out.println("Vozilo sa VIN oznakom " + removeVehicleByVIN + " je ukonjeno iz flote");
                        LOGGER.info("Uspješno uklonjeno vozilo.");
                    } catch (NoSuchVehicleException e) {
                        System.err.println(e.getMessage());
                        LOGGER.warning("Vozilo nije uklonjeno, upisan nepostojeći VIN.");
                    }
                    break;

                case "5":
                    System.out.println("Izašli ste iz programa. Doviđenja!");
                    System.exit(0);
                    LOGGER.info("Uspješno napuštena aplikacija.");
                    break;

                default:
                    System.out.println("Odabrali ste nepostojeću opciju, molimo pokušajte ponovno.");

            }

        }

    }

}
