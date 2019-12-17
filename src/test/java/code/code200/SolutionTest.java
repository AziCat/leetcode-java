package code.code200;

import code.code200.question151.Solution;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void reverseWords() throws Exception {
        String s = "  hello world!  ";
        Solution solution = new Solution();
        Assert.assertEquals("world! hello",solution.reverseWords(s));
    }

}