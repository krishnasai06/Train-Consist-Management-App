import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class BogieTest {

    private List<Bogie> getBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("Sleeper", 70));
        list.add(new Bogie("First Class", 24));
        return list;
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<Bogie>> result = getBogies().stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(result.containsKey("Sleeper"));
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<Bogie>> result = getBogies().stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        Map<String, List<Bogie>> result = getBogies().stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        Map<String, List<Bogie>> result = list.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 80));

        Map<String, List<Bogie>> result = list.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(1, result.size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<Bogie>> result = getBogies().stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        Map<String, List<Bogie>> result = getBogies().stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> original = getBogies();

        Map<String, List<Bogie>> result = original.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(4, original.size());
    }
}