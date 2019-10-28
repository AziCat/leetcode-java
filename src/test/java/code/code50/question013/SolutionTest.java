package code.code50.question013;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();
    @Test
    public void romanToInt() {
        assertEquals(3, solution.romanToInt("III"));
    }
    @Test
    public void romanToInt1() {
        assertEquals(4, solution.romanToInt("IV"));
    }
    @Test
    public void romanToInt3() {
        assertEquals(58, solution.romanToInt("LVIII"));
    }
    @Test
    public void romanToInt2() {
        assertEquals(1994, solution.romanToInt("MCMXCIV"));
    }

}