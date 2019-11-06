package code.code100.question096;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void numTrees() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(5, solution.numTrees(3));
    }
    @Test
    public void numTrees1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.numTrees(0));
    }

    @Test
    public void numTrees2() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.numTrees(1));
    }

    @Test
    public void numTrees3() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.numTrees(2));
    }

}