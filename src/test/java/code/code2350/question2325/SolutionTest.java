package code.code2350.question2325;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testDecodeMessage() {
        Solution solution = new Solution();
        String ans = solution.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
        Assert.assertEquals("this is a secret", ans);
    }
}