package code.code2800.question2798;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution solution = new Solution();
        int r = solution.numberOfEmployeesWhoMetTarget(new int[]{0, 1, 2, 3, 4}, 2);
        assertEquals(3, r);
        r = solution.numberOfEmployeesWhoMetTarget(new int[]{48, 28}, 1);
        assertEquals(2, r);
    }
}