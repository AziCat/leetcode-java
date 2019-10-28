package code.code50.question047;

import org.junit.Test;

import java.util.List;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void permuteUnique() {
        int[] nums = {1, 1,2, 2};
        List<List<Integer>> list = solution.permuteUnique(nums);
        list.forEach(item -> System.out.println(item.toString()));
    }
}