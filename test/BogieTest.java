import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SearchWithValidationTest {

    private boolean search(String[] arr, String key) {

        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        java.util.Arrays.sort(arr);

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

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] arr = {};
        assertThrows(IllegalStateException.class,
                () -> search(arr, "BG101"));
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] arr = {"BG101","BG205"};
        assertDoesNotThrow(() -> search(arr, "BG101"));
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};
        assertTrue(search(arr, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};
        assertFalse(search(arr, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] arr = {"BG101"};
        assertTrue(search(arr, "BG101"));
    }
}