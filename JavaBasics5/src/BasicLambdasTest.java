import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class BasicLambdasTest {

    // Number 1
    @Test
    public void testSortByLength() {
        String array[] = { "test", "te", "test1", "tes", "t" };

        Comparator<String> lengthComparator = new Comparator<String>() {
            @Override
            public int compare(String i1, String i2) {
                return i1.length() - i2.length();
            }
        };
        List<String> sorted = Arrays.asList(array).stream().sorted(lengthComparator).collect(Collectors.toList());
        String test[] = { "t", "te", "tes", "test", "test1" };
        assertEquals(sorted, Arrays.asList(test));
    }

    @Test
    public void testSortByReverseLength() {
        String array[] = { "test", "te", "test1", "tes", "t" };

        Comparator<String> lengthComparator = new Comparator<String>() {
            @Override
            public int compare(String i1, String i2) {
                return i2.length() - i1.length();
            }
        };
        List<String> sorted = Arrays.asList(array).stream().sorted(lengthComparator).collect(Collectors.toList());
        String test[] = { "t", "te", "tes", "test", "test1" };
        List<String> reverse = Arrays.asList(test);
        System.out.println("Testing sorted " + sorted);
        Collections.reverse(reverse);
        System.out.println("Testing array what it should be " + reverse);
        assertEquals(sorted, reverse);
    }

    @Test
    public void alphabetically() {
        String array[] = { "apple", "car", "dog", "banna", "test" };

        Comparator<String> lengthComparator = new Comparator<String>() {
            @Override
            public int compare(String i1, String i2) {
                return i1.charAt(0) - i2.charAt(0);
            }
        };
        List<String> sorted = Arrays.asList(array).stream().sorted(lengthComparator).collect(Collectors.toList());
        String test[] = { "apple", "banna", "car", "dog", "test" };
        List<String> actual = Arrays.asList(test);
        System.out.println("Testing sorted " + sorted);
        System.out.println("Testing array what it should be " + actual);
        assertEquals(sorted, actual);
    }

    @Test
    public void testStringContainEFirst() {
        String array[] = { "apple", "car", "dog", "banna", "test", "egg", "elf" };

        List<String> eFirst = Arrays.asList(array).stream().filter((s1) -> s1.charAt(0) == 'e')
                .collect(Collectors.toList());
        List<String> notE = Arrays.asList(array).stream().filter((s1) -> s1.charAt(0) != 'e')
                .collect(Collectors.toList());
        eFirst.addAll(notE);
        List<String> sorted = eFirst;
        String test[] = { "egg", "elf", "apple", "car", "dog", "banna", "test" };
        List<String> actual = Arrays.asList(test);
        System.out.println("Testing sorted " + sorted);
        System.out.println("Testing array what it should be " + actual);
        assertEquals(sorted, actual);
    }

    // Number 2
    @Test
    public void TestCommaSep() {
        Integer input[] = { 3, 44 };
        String result = CommaSeperated.getCommaSeperated(Arrays.asList(input));
        String acutal = "o3,e44";
        assertEquals(acutal, result);
    }

    // number 3
    @Test
    public void testLength3() {
        List<String> expected = new ArrayList<>(List.of("app", "abb"));

        List<String> test = new ArrayList<>(List.of("ham", "app", "apple", "abb", "hello"));
        assertEquals(expected, StartA3Char.getStrings(test));
    }
}
