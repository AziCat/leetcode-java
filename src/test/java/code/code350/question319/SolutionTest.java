package code.code350.question319;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void bulbSwitch() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.bulbSwitch(2));
    }

    @Test
    public void bulbSwitch1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.bulbSwitch(3));
    }

    @Test
    public void bulbSwitch2() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.bulbSwitch(5));
    }

    @Test
    public void bulbSwitch3() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.bulbSwitch(17));
    }
}