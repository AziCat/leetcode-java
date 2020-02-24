package code.code300.question292;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void canWinNim() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.canWinNim(4));
    }

    @Test
    public void canWinNim1() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.canWinNim(5));
    }

}