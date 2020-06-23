package code.code1000.question983;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void mincostTickets() {
        Solution solution = new Solution();
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        Assert.assertEquals(11, solution.mincostTickets(days, costs));
    }

    @Test
    public void mincostTickets1() {
        Solution solution = new Solution();
        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs = {2, 7, 15};
        Assert.assertEquals(17, solution.mincostTickets(days, costs));
    }
}