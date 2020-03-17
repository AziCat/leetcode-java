package code.code350.question310;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void findMinHeightTrees() throws Exception {
        Solution solution = new Solution();
        int[][] edges = {
                {0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}
        };
        List<Integer> ans = solution.findMinHeightTrees(6, edges);
        Assert.assertEquals("[3, 4]", ans.toString());
    }
@Test
    public void findMinHeightTrees1() throws Exception {
        Solution solution = new Solution();
        int[][] edges = {
                {0, 1}, {1, 2}, {1, 3}
        };
        List<Integer> ans = solution.findMinHeightTrees(4, edges);
        Assert.assertEquals("[1]", ans.toString());
    }
}