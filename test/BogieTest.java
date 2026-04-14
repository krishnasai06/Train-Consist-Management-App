import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {

    private boolean linearSearch(String[] arr, String key) {
        for (String val : arr) {
            if (val.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(linearSearch(arr, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(linearSearch(arr, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] arr = {"BG101","BG205","BG309"};
        assertTrue(linearSearch(arr, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] arr = {"BG101","BG205","BG550"};
        assertTrue(linearSearch(arr, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] arr = {"BG101"};
        assertTrue(linearSearch(arr, "BG101"));
    }
}