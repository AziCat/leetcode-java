package code.code300.question274;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void hIndex() throws Exception {
        Solution solution = new Solution();
        int[] citations = {3, 0, 6, 1, 5};
        Assert.assertEquals(3, solution.hIndex(citations));
    }

    @Test
    public void hIndex1() throws Exception {
        Solution solution = new Solution();
        int[] citations = {1};
        Assert.assertEquals(1, solution.hIndex(citations));
    }

    @Test
    public void hIndex2() throws Exception {
        Solution solution = new Solution();
        int[] citations = {3, 2, 10};
        Assert.assertEquals(2, solution.hIndex(citations));
    }
}