package code.code50.question014;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void longestCommonPrefix() {
        String[] strs = {"flower", "flow", "flight"};
        Assert.assertEquals("fl", solution.longestCommonPrefix(strs));
    }
    @Test
    public void longestCommonPrefix1() {
        String[] strs = {"ower", "flow", "flight"};
        Assert.assertEquals("", solution.longestCommonPrefix(strs));
    }
    @Test
    public void longestCommonPrefix2() {
        String[] strs = {"ower"};
        Assert.assertEquals("ower", solution.longestCommonPrefix(strs));
    }
    @Test
    public void longestCommonPrefix3() {
        String[] strs = {"aa","a"};
        Assert.assertEquals("a", solution.longestCommonPrefix(strs));
    }
}