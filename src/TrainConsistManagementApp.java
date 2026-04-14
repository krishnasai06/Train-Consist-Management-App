import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

// ✅ Custom Exception (UC14)
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// ✅ Passenger Bogie
class PassengerBogie {
    String type;
    int capacity;

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

// ✅ Goods Bogie
class GoodsBogie {
    String type;
    String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() { return type; }
    public String getCargo() { return cargo; }
}

// ✅ Main Class
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        try {
            // =============================
            // UC7: Sorting
            // =============================
            List<PassengerBogie> passengers = new ArrayList<>();
            passengers.add(new PassengerBogie("Sleeper", 72));
            passengers.add(new PassengerBogie("AC Chair", 56));
            passengers.add(new PassengerBogie("First Class", 24));

            passengers.sort(Comparator.comparingInt(PassengerBogie::getCapacity));

            System.out.println("Sorted Bogies:");
            passengers.forEach(b -> System.out.println(b.getType() + " " + b.getCapacity()));

            // =============================
            // UC8: Filtering
            // =============================
            List<PassengerBogie> filtered = passengers.stream()
                    .filter(b -> b.getCapacity() > 60)
                    .collect(Collectors.toList());

            System.out.println("\nFiltered (Capacity > 60):");
            filtered.forEach(b -> System.out.println(b.getType()));

            // =============================
            // UC9: Grouping
            // =============================
            Map<String, List<PassengerBogie>> grouped =
                    passengers.stream()
                            .collect(Collectors.groupingBy(PassengerBogie::getType));

            System.out.println("\nGrouped Bogies:");
            grouped.forEach((k, v) -> System.out.println(k + " -> " + v.size()));

            // =============================
            // UC10: Total Seats
            // =============================
            int totalSeats = passengers.stream()
                    .map(PassengerBogie::getCapacity)
                    .reduce(0, Integer::sum);

            System.out.println("\nTotal Seats: " + totalSeats);

            // =============================
            // UC11: Regex Validation
            // =============================
            String trainId = "TRN-1234";
            String cargoCode = "PET-AB";

            boolean validTrain = Pattern.matches("TRN-\\d{4}", trainId);
            boolean validCargo = Pattern.matches("PET-[A-Z]{2}", cargoCode);

            System.out.println("\nTrain ID Valid: " + validTrain);
            System.out.println("Cargo Code Valid: " + validCargo);

            // =============================
            // UC12: Safety Check
            // =============================
            List<GoodsBogie> goods = new ArrayList<>();
            goods.add(new GoodsBogie("Cylindrical", "Petroleum"));
            goods.add(new GoodsBogie("Open", "Coal"));

            boolean isSafe = goods.stream()
                    .allMatch(b ->
                            !b.getType().equals("Cylindrical") ||
                                    b.getCargo().equals("Petroleum")
                    );

            System.out.println("\nSafety Check: " + (isSafe ? "SAFE" : "NOT SAFE"));

            // =============================
            // UC13: Performance Comparison
            // =============================
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

            // =============================
            // UC14: Exception Handling
            // =============================
            PassengerBogie invalid = new PassengerBogie("Test", -5); // ❌ will throw

        } catch (InvalidCapacityException e) {
            System.out.println("\nException: " + e.getMessage());
        }
    }
}