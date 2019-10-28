package code.code50.question046;

import org.junit.Test;

import java.util.List;

public class SolutionTest {
    private Solution solution = new Solution();
    @Test
    public void permute() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = solution.permute(nums);
        list.forEach(item-> System.out.println(item.toString()));

    }

    @Test
    public void permute1() {
        int[] nums = {1,2};
        List<List<Integer>> list = solution.permute(nums);
        list.forEach(item-> System.out.println(item.toString()));

    }

    @Test
    public void permute21() {
        int[] nums = {1,2,3,4};
        List<List<Integer>> list = solution.permute(nums);
        list.forEach(item-> System.out.println(item.toString()));

    }
}