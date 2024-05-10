package code.code2100.question2079;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(14, solution.wateringPlants(new int[]{2, 2, 3, 3}, 5));
        assertEquals(4, solution.wateringPlants(new int[]{2, 2, 3, 3}, 10));
        assertEquals(30, solution.wateringPlants(new int[]{1, 1, 1, 4, 2, 3}, 4));
    }
}