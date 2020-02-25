package code.code300.question299;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void getHint() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("2A1B",solution.getHint("1113","0111"));
    }
    @Test
    public void getHint1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("1A3B",solution.getHint("1807","7810"));
    }

}