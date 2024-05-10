package code.code2750.quesiton2739;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(60, solution.distanceTraveled(5, 10));
        assertEquals(10, solution.distanceTraveled(1, 2));
        assertEquals(110, solution.distanceTraveled(9, 2));
        assertEquals(170, solution.distanceTraveled(14, 10));
    }
}