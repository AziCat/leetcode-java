package code.code50.question038;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void countAndSay() {
        assertEquals("1", solution.countAndSay(1));
    }

    @Test
    public void countAndSay2() {
        assertEquals("11", solution.countAndSay(2));
    }

    @Test
    public void countAndSay3() {
        assertEquals("21", solution.countAndSay(3));
    }

    @Test
    public void countAndSay4() {
        assertEquals("1211", solution.countAndSay(4));
    }

    @Test
    public void countAndSay5() {
        assertEquals("111221", solution.countAndSay(5));
    }
}