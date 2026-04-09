import java.util.LinkedList;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create LinkedList for train consist
        LinkedList<String> trainConsist = new LinkedList<>();

        // Add bogies
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        // Insert Pantry Car at position 2 (index 1-based → index 1 or 2? here using index 2)
        trainConsist.add(2, "Pantry Car");

        // Display after insertion
        System.out.println("\nAfter adding bogies and Pantry Car:");
        System.out.println(trainConsist);

        // Remove first and last bogie
        trainConsist.removeFirst();
        trainConsist.removeLast();

        // Final ordered consist
        System.out.println("\nFinal Train Consist:");
        System.out.println(trainConsist);
    }
}