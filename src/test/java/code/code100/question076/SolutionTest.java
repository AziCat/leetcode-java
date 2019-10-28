package code.code100.question076;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void minWindow() {
        Solution solution = new Solution();
        Assert.assertEquals("CBBA", solution.minWindow("FADOBECODBBANCBBA", "ABBC"));
    }

    @Test
    public void minWindow1() {
        Solution solution = new Solution();
        Assert.assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void minWindow2() {
        Solution solution = new Solution();
        Assert.assertEquals("BCEA", solution.minWindow("AODBCEAFD", "ABC"));
    }
}