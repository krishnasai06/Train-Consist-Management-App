import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class BogieTest {

    private List<Bogie> getBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 24));
        return list;
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int total = getBogies().stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        assertEquals(152, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int total = getBogies().stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(152, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));

        int total = list.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        int total = list.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> list = getBogies();

        int total = list.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        assertEquals(152, total);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> list = getBogies();

        int total = list.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(152, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> original = getBogies();

        int total = original.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(3, original.size()); // unchanged
    }
}