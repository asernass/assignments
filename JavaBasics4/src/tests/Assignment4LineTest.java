package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

import assignments.Line;

public class Assignment4LineTest {
    @Test
    public void testGetSlope() {
        Line l1 = new Line(1, 2, 3, 6, 10);
        Line l3 = new Line(1, 3, 6, 9, 30);
        assertEquals(l1.getSlope(), 3, .001); // they are eqaul
        assertNotEquals(l3.getSlope(), 3, .001); // false
    }

    @Test
    public void testGetDistance() {

        Line l1 = new Line(1, 2, 3, 6, 10);
        Line l2 = new Line(2, 3, 6, 9, 20);
        assertNotEquals(l1.getDistance(), l2.getDistance()); // different distances
    }

    @Test
    public void testParaellelTo() {
        Line l1 = new Line(1, 2, 3, 6, 10);
        Line l2 = new Line(2, 3, 6, 9, 20);
        Line l3 = new Line(1, 3, 6, 9, 30);
        Line l4 = new Line(2, 3, 6, 9, 40);
        assertTrue(l1.paraellelTo(l2)); // they are eqaul
        assertFalse(l3.paraellelTo(l4)); // false
    }

}
