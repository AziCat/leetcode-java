package code.code400.question394;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void decodeString() {
        Solution solution = new Solution();
        Assert.assertEquals("accaccacc",solution.decodeString("3[a2[c]]"));
    }
    @Test
    public void decodeString1() {
        Solution solution = new Solution();
        Assert.assertEquals("aaabcbc",solution.decodeString("3[a]2[bc]"));
    }
    @Test
    public void decodeString2() {
        Solution solution = new Solution();
        Assert.assertEquals("abcabccdcdcdef",solution.decodeString("2[abc]3[cd]ef"));
    }
    @Test
    public void decodeString22() {
        Solution solution = new Solution();
        Assert.assertEquals("abccdcdcdxyz",solution.decodeString("abc3[cd]xyz"));
    }

    @Test
    public void decodeString212() {
        Solution solution = new Solution();
        Assert.assertEquals("",solution.decodeString(""));
    }

    @Test
    public void decodeString2112() {
        Solution solution = new Solution();
        Assert.assertEquals("abcdcdcdabcdcdcdxyxyxyxy",solution.decodeString("2[ab3[cd]]4[xy]"));
    }
}