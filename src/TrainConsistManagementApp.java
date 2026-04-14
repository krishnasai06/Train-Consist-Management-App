import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("First Class", 24));

        // ✅ Grouping by bogie type (name)
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // Display grouped result
        for (String key : grouped.keySet()) {
            System.out.println("Type: " + key);

            for (Bogie b : grouped.get(key)) {
                System.out.println("   Capacity: " + b.getCapacity());
            }
        }
    }
}