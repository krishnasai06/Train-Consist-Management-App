import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        String[] bogieIds = {}; // 🔴 try empty case
        String searchKey = "BG101";

        try {
            boolean found = searchBogie(bogieIds, searchKey);

            if (found) {
                System.out.println("Bogie ID " + searchKey + " FOUND");
            } else {
                System.out.println("Bogie ID " + searchKey + " NOT FOUND");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ✅ Search with validation (Binary Search used internally)
    public static boolean searchBogie(String[] arr, String key) {

        // 🔥 UC20: Fail-Fast Validation
        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        // ensure sorted
        Arrays.sort(arr);

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = key.compareTo(arr[mid]);

            if (cmp == 0) return true;
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }
}