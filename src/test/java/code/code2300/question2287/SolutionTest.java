package code.code2300.question2287;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testRearrangeCharacters() {
        Solution solution = new Solution();
        int ans = solution.rearrangeCharacters("ilovecodingonleetcode", "code");
        Assert.assertEquals(2, ans);
    }
}