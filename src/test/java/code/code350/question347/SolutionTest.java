package code.code350.question347;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void topKFrequent() throws Exception {
        Solution solution = new Solution();
        List<Integer> ans = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        Assert.assertEquals("[2, 1]", ans.toString());
    }

    @Test
    public void topKFrequent1() throws Exception {
        Solution solution = new Solution();
        List<Integer> ans = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 1);
        Assert.assertEquals("[1]", ans.toString());
    }
}