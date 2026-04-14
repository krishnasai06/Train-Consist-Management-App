import java.util.*;

// Bogie class
class Bogie {
    String name;
    int capacity;

    // Constructor
    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    // Display method
    public void display() {
        System.out.println("Bogie: " + name + " | Capacity: " + capacity);
    }
}

// Main class
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Step 1: Create List
        List<Bogie> bogies = new ArrayList<>();

        // Step 2: Add passenger bogies
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        // Step 3: Sort using Comparator (by capacity)
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        // Step 4: Display sorted bogies
        System.out.println("Bogies sorted by capacity (Ascending):");
        for (Bogie b : bogies) {
            b.display();
        }
    }
}