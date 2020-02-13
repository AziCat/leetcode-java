package code.code250.question228;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void summaryRanges() throws Exception {
        Solution solution = new Solution();
        int[] nums = {};
        List<String> ans = solution.summaryRanges(nums);
        Assert.assertEquals("[]", ans.toString());
    }

    @Test
    public void summaryRanges1() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1};
        List<String> ans = solution.summaryRanges(nums);
        Assert.assertEquals("[1]", ans.toString());
    }

    @Test
    public void summaryRanges2() throws Exception {
        Solution solution = new Solution();
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> ans = solution.summaryRanges(nums);
        Assert.assertEquals("[0->2, 4->5, 7]", ans.toString());
    }
}