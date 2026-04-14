import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PassengerBogieTest {

    @Test
    void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            PassengerBogie bogie = new PassengerBogie("Sleeper", 72);
            assertEquals(72, bogie.getCapacity());
        });
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        InvalidCapacityException ex = assertThrows(
                InvalidCapacityException.class,
                () -> new PassengerBogie("Sleeper", -10)
        );

        assertEquals(
                "Capacity must be greater than zero",
                ex.getMessage()
        );
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(
                InvalidCapacityException.class,
                () -> new PassengerBogie("AC Chair", 0)
        );
    }

    @Test
    void testException_ExceptionMessageValidation() {
        InvalidCapacityException ex = assertThrows(
                InvalidCapacityException.class,
                () -> new PassengerBogie("First Class", -1)
        );

        assertEquals(
                "Capacity must be greater than zero",
                ex.getMessage()
        );
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 72);

        assertEquals("Sleeper", bogie.getType());
        assertEquals(72, bogie.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            PassengerBogie b2 = new PassengerBogie("AC Chair", 56);
            PassengerBogie b3 = new PassengerBogie("First Class", 24);

            assertEquals(72, b1.getCapacity());
            assertEquals(56, b2.getCapacity());
            assertEquals(24, b3.getCapacity());
        });
    }
}