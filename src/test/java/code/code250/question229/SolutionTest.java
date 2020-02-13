package code.code250.question229;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void majorityElement() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2, 2, 3, 3};
        List<Integer> ans = solution.majorityElement(nums);
        Assert.assertEquals("[]", ans.toString());
    }

    @Test
    public void majorityElement1() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        List<Integer> ans = solution.majorityElement(nums);
        Assert.assertEquals("[1, 2]", ans.toString());
    }

    @Test
    public void majorityElement2() throws Exception {
        Solution solution = new Solution();
        int[] nums = {3, 2, 3};
        List<Integer> ans = solution.majorityElement(nums);
        Assert.assertEquals("[3]", ans.toString());
    }

    @Test
    public void majorityElement3() throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2, 3, 2, 1, 1, 3};
        List<Integer> ans = solution.majorityElement(nums);
        Assert.assertEquals("[1, 2]", ans.toString());
    }
}