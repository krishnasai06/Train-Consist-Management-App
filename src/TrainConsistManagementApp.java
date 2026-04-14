import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";

        // ✅ Ensure sorted (important for binary search)
        Arrays.sort(bogieIds);

        boolean found = binarySearch(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie ID " + searchKey + " FOUND");
        } else {
            System.out.println("Bogie ID " + searchKey + " NOT FOUND");
        }
    }

    // ✅ Binary Search Method
    public static boolean binarySearch(String[] arr, String key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison = key.compareTo(arr[mid]);

            if (comparison == 0) {
                return true; // found
            } else if (comparison < 0) {
                high = mid - 1; // search left
            } else {
                low = mid + 1; // search right
            }
        }

        return false; // not found
    }
}