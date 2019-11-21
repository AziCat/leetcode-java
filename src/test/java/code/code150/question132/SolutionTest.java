package code.code150.question132;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void minCut() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.minCut("aaaa"));
    }

    @Test
    public void minCut1() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.minCut("ababababababababababababcbabababababababababababa"));
    }

    @Test
    public void minCut2() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.minCut("aaabaa"));
    }

    @Test
    public void minCut3() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.minCut("abbab"));
    }

    @Test
    public void minCut23() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(89, solution.minCut("kwtbjmsjvbrwriqwxadwnufplszhqccayvdhhvscxjaqsrmrrqngmuvxnugdzjfxeihogzsdjtvdmkudckjoggltcuybddbjoizu"));
    }
}