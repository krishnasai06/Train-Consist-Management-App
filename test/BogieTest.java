import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

class RegexTest {

    String trainPattern = "TRN-\\d{4}";
    String cargoPattern = "PET-[A-Z]{2}";

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(Pattern.matches(trainPattern, "TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(Pattern.matches(trainPattern, "TRAIN12"));
        assertFalse(Pattern.matches(trainPattern, "TRN12A"));
        assertFalse(Pattern.matches(trainPattern, "1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(Pattern.matches(cargoPattern, "PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(Pattern.matches(cargoPattern, "PET-ab"));
        assertFalse(Pattern.matches(cargoPattern, "PET123"));
        assertFalse(Pattern.matches(cargoPattern, "AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(Pattern.matches(trainPattern, "TRN-123"));
        assertFalse(Pattern.matches(trainPattern, "TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(Pattern.matches(cargoPattern, "PET-Ab"));
        assertFalse(Pattern.matches(cargoPattern, "PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(Pattern.matches(trainPattern, ""));
        assertFalse(Pattern.matches(cargoPattern, ""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(Pattern.matches(trainPattern, "TRN-1234XYZ"));
        assertFalse(Pattern.matches(cargoPattern, "PET-ABCD"));
    }
}