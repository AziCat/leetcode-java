package code.code150.question134;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void canCompleteCircuit() throws Exception {
        Solution solution = new Solution();
        int[] gas = {5, 2, 4, 1};
        int[] cost = {1, 4, 6, 4};
        int i = solution.canCompleteCircuit(gas, cost);
        Assert.assertEquals(-1, i);
    }

    @Test
    public void canCompleteCircuit2() throws Exception {
        Solution solution = new Solution();
        int[] gas = {3, 3, 4};
        int[] cost = {3, 4, 4};
        int i = solution.canCompleteCircuit(gas, cost);
        Assert.assertEquals(-1, i);
    }

    @Test
    public void canCompleteCircuit3() throws Exception {
        Solution solution = new Solution();
        int[] gas = {3, 1, 1};
        int[] cost = {1, 2, 2};
        int i = solution.canCompleteCircuit(gas, cost);
        Assert.assertEquals(0, i);
    }

    @Test
    public void canCompleteCircuit1() throws Exception {
        Solution solution = new Solution();
        int[] gas = {5, 2, 4, 1, 3, 8};
        int[] cost = {6, 1, 3, 4, 2, 6};
        int i = solution.canCompleteCircuit(gas, cost);
        Assert.assertEquals(4, i);
    }

}