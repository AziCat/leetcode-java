package code.code250.question205;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void isIsomorphic() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isIsomorphic("add", "egg"));
    }
    @Test
    public void isIsomorphic1() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isIsomorphic("paper", "title"));
    }

    @Test
    public void isIsomorphic2() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isIsomorphic("adc", "egg"));
    }
    @Test
    public void isIsomorphic22() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isIsomorphic("qwertyuiop[]asdfghjkl;'\\zxcvbnm,./", "',.pyfgcrl/=aoeuidhtns-\\;qjkxbmwvz"));
    }

}