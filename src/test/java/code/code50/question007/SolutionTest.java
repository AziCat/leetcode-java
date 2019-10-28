package code.code50.question007;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();
    @Test
    public void reverse() {
        assertEquals(321, solution.reverse(123));
    }
    @Test
    public void reverse1() {
        assertEquals(21, solution.reverse(120));
    }
    @Test
    public void reverse2() {
        assertEquals(-321, solution.reverse(-123));
    }
}