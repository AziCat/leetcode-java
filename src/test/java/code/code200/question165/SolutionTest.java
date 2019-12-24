package code.code200.question165;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void compareVersion() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(1,solution.compareVersion("1.0.1","1.0"));
    }
    @Test
    public void compareVersion1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(0,solution.compareVersion("1.0.1.0","1.0.1"));
    }
    @Test
    public void compareVersion2() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(-1,solution.compareVersion("1.0.1.0","1.0.3"));
    }

}