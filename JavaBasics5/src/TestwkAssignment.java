import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import assignment.Assign2Functional;
import assignment.AssignLambdas1;
import assignment.PerformOperation;

public class TestwkAssignment {
    @Test
    public void test1Lambdas() {
        PerformOperation operation;

        operation = AssignLambdas1.isOdd();
        int num = 4;
        boolean result = AssignLambdas1.isNumber(operation, num);
        assertEquals(false, result); // its even
        num = 3;
        result = AssignLambdas1.isNumber(operation, num);
        assertEquals(true, result); // it is odd

        operation = AssignLambdas1.isPrime();
        num = 11;
        result = AssignLambdas1.isNumber(operation, num);

        assertEquals(true, result);
        num = 6;
        result = AssignLambdas1.isNumber(operation, num);

        assertNotEquals(true, result);

        operation = AssignLambdas1.isPalindrome();

        num = 67;
        result = AssignLambdas1.isNumber(operation, num);
        assertEquals(false, result);

        num = 676;
        result = AssignLambdas1.isNumber(operation, num);
        assertEquals(true, result);
    }

    @Test
    public void testRightMost() {
        List<Integer> list = new ArrayList<>(List.of(1, 22, 93));
        List<Integer> expected = new ArrayList<>(List.of(1, 2, 3));
        assertEquals(expected, Assign2Functional.getRight(list));
    }

    @Test
    public void testDouble() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> expected = new ArrayList<>(List.of(2, 4, 6));
        assertEquals(expected, Assign2Functional.doubling(list));
    }

    @Test
    public void testNoX() {
        List<String> list = new ArrayList<>(List.of("ax", "bb", "cx"));
        List<String> expected = new ArrayList<>(List.of("a", "bb", "c"));
        assertEquals(expected, Assign2Functional.noX(list));
    }

    @Test
    public void testRecursion() {
        int list[] = { 2, 4, 8 };
        int list2[] = { 2, 4, 4, 8 };
        assertTrue(Assign2Functional.groupSumClump(list, 0, 10));
        assertFalse(Assign2Functional.groupSumClump(list2, 0, 14));
    }
}
