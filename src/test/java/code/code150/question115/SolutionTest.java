package code.code150.question115;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void numDistinct() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(6,solution.numDistinct("babgbagb","bb"));
    }

    @Test
    public void numDistinct1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(3,solution.numDistinct("rabbbit","rabbit"));
    }
    @Test
    public void numDistinct2() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(0,solution.numDistinct("","a"));
    }

}