import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

// =======================
// UC14: Custom Exception
// =======================
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// =======================
// UC15: Runtime Exception
// =======================
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// =======================
// Passenger Bogie
// =======================
class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() { return type; }
    public int getCapacity() { return capacity; }
}

// =======================
// Goods Bogie
// =======================
class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type) {
        this.type = type;
    }

    public String getType() { return type; }
    public String getCargo() { return cargo; }

    // UC15: Safe cargo assignment
    public void assignCargo(String cargo) {
        try {
            if (type.equals("Rectangular") && cargo.equals("Petroleum")) {
                throw new CargoSafetyException("Unsafe: Rectangular cannot carry Petroleum");
            }
            this.cargo = cargo;
            System.out.println("Cargo assigned: " + cargo);

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Assignment completed for " + type);
        }
    }
}

// =======================
// MAIN CLASS
// =======================
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        try {
            // =======================
            // UC7: Sorting
            // =======================
            List<PassengerBogie> passengers = new ArrayList<>();
            passengers.add(new PassengerBogie("Sleeper", 72));
            passengers.add(new PassengerBogie("AC Chair", 56));
            passengers.add(new PassengerBogie("First Class", 24));

            passengers.sort(Comparator.comparingInt(PassengerBogie::getCapacity));

            System.out.println("=== Sorted Bogies ===");
            passengers.forEach(b -> System.out.println(b.getType() + " " + b.getCapacity()));

            // =======================
            // UC8: Filtering
            // =======================
            List<PassengerBogie> filtered = passengers.stream()
                    .filter(b -> b.getCapacity() > 60)
                    .collect(Collectors.toList());

            System.out.println("\n=== Filtered (>60) ===");
            filtered.forEach(b -> System.out.println(b.getType()));

            // =======================
            // UC9: Grouping
            // =======================
            Map<String, List<PassengerBogie>> grouped =
                    passengers.stream()
                            .collect(Collectors.groupingBy(PassengerBogie::getType));

            System.out.println("\n=== Grouped ===");
            grouped.forEach((k, v) -> System.out.println(k + " -> " + v.size()));

            // =======================
            // UC10: Total Seats
            // =======================
            int totalSeats = passengers.stream()
                    .map(PassengerBogie::getCapacity)
                    .reduce(0, Integer::sum);

            System.out.println("\nTotal Seats: " + totalSeats);

            // =======================
            // UC11: Regex Validation
            // =======================
            String trainId = "TRN-1234";
            String cargoCode = "PET-AB";

            boolean validTrain = Pattern.matches("TRN-\\d{4}", trainId);
            boolean validCargo = Pattern.matches("PET-[A-Z]{2}", cargoCode);

            System.out.println("\nTrain ID Valid: " + validTrain);
            System.out.println("Cargo Code Valid: " + validCargo);

            // =======================
            // UC12: Safety Check
            // =======================
            List<GoodsBogie> goods = new ArrayList<>();
            goods.add(new GoodsBogie("Cylindrical"));
            goods.add(new GoodsBogie("Open"));

            goods.get(0).assignCargo("Petroleum");
            goods.get(1).assignCargo("Coal");

            boolean isSafe = goods.stream()
                    .allMatch(b ->
                            !b.getType().equals("Cylindrical") ||
                                    "Petroleum".equals(b.getCargo())
                    );

            System.out.println("\nSafety Check: " + (isSafe ? "SAFE" : "NOT SAFE"));

            // =======================
            // UC13: Performance
            // =======================
            List<PassengerBogie> bigList = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                bigList.add(new PassengerBogie("B" + i, (i % 100) + 1));
            }

            long startLoop = System.nanoTime();
            List<PassengerBogie> loopResult = new ArrayList<>();
            for (PassengerBogie b : bigList) {
                if (b.getCapacity() > 60) loopResult.add(b);
            }
            long endLoop = System.nanoTime();

            long startStream = System.nanoTime();
            List<PassengerBogie> streamResult = bigList.stream()
                    .filter(b -> b.getCapacity() > 60)
                    .collect(Collectors.toList());
            long endStream = System.nanoTime();

            System.out.println("\nLoop Time: " + (endLoop - startLoop));
            System.out.println("Stream Time: " + (endStream - startStream));

            // =======================
            // UC14: Exception Demo
            // =======================
            PassengerBogie invalid = new PassengerBogie("Test", -5); // will throw

        } catch (InvalidCapacityException e) {
            System.out.println("\nException: " + e.getMessage());
        }

        System.out.println("\n=== Program Completed Safely ===");
    }
}