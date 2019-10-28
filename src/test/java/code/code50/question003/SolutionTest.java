package code.code50.question003;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void lengthOfLongestSubstring1() {
        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring("abcabcbb");
        Assert.assertEquals(3, length);
    }
    @Test
    public void lengthOfLongestSubstring2() {
        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring("bbbbbbbb");
        Assert.assertEquals(1, length);
    }
    @Test
    public void lengthOfLongestSubstring3() {
        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring("pwwkew");
        Assert.assertEquals(3, length);
    }

    @Test
    public void lengthOfLongestSubstring4() {
        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring("abba");
        Assert.assertEquals(2, length);
    }
}