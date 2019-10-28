package code.code100.question078;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void subsets() {
        Solution s = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = s.subsets(nums);
        System.out.println(ans.toString());
        Assert.assertEquals(8, ans.size());
    }

    @Test
    public void subsets1() {
        Solution s = new Solution();
        int[] nums = {2, 4, 3, 1};
        List<List<Integer>> ans = s.subsets(nums);
        System.out.println(ans.toString());
        Assert.assertEquals(16, ans.size());
    }
}