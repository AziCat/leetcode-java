package code.code500.question467;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest extends TestCase {

    @Test
    public void testFindSubstringInWraproundString() {
        Solution solution = new Solution();
        int ans = solution.findSubstringInWraproundString("zayzab");
        Assert.assertEquals(10, ans);
        ans = solution.findSubstringInWraproundString("cac");
        Assert.assertEquals(2, ans);
        ans = solution.findSubstringInWraproundString("zab");
        Assert.assertEquals(6, ans);
    }
}