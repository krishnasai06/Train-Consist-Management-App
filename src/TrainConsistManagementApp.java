public class TrainConsistManagementApp {

    public static void main(String[] args) {

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";

        boolean found = false;

        // ✅ Linear Search
        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(searchKey)) {
                found = true;
                break; // stop when found
            }
        }

        if (found) {
            System.out.println("Bogie ID " + searchKey + " FOUND");
        } else {
            System.out.println("Bogie ID " + searchKey + " NOT FOUND");
        }
    }
}