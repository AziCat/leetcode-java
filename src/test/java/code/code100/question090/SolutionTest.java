package code.code100.question090;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void subsetsWithDup() {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> ans = solution.subsetsWithDup(nums);
        //ans.forEach(item -> System.out.println(item.toString()));
        Assert.assertEquals(6, ans.size());
    }

    @Test
    public void subsetsWithDup1() {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2, 3};
        List<List<Integer>> ans = solution.subsetsWithDup(nums);
        ans.forEach(item -> System.out.println(item.toString()));
        Assert.assertEquals(12, ans.size());
    }
}