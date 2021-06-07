package tests;

import org.junit.Test;

import assignments.Assignment1;

public class Assignment1Test {
    @Test
    public void testSingleton() {
        Assignment1 instance1 = Assignment1.getInstance();
        Assignment1 instance2 = Assignment1.getInstance();
    }
}
