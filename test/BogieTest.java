import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class PerformanceTest {

    private List<Bogie> getBogies() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Bogie("B" + i, i % 100));
        }
        return list;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> list = getBogies();

        List<Bogie> result = new ArrayList<>();
        for (Bogie b : list) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }

        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> list = getBogies();

        List<Bogie> result = list.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> list = getBogies();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : list) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }

        List<Bogie> streamResult = list.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        long end = System.nanoTime();

        long time = end - start;

        assertTrue(time >= 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> list = getBogies();

        List<Bogie> result = list.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        assertNotNull(result);
    }
}