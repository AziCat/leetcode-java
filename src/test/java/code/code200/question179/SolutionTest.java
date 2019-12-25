package code.code200.question179;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void largestNumber() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("9534330", solution.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    @Test
    public void largestNumber1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("9609938824824769735703560743981399", solution.largestNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247}));
    }
}