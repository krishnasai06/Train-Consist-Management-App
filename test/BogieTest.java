import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BogieTest {

    @Test
    void testCapacity() {
        Bogie bogie = new Bogie("Sleeper", 72);
        assertEquals(72, bogie.getCapacity());
    }

    @Test
    void testName() {
        Bogie bogie = new Bogie("AC Chair", 56);
        assertEquals("AC Chair", bogie.getName());
    }
}