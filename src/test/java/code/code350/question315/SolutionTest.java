package code.code350.question315;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void countSmaller() throws Exception {
        Solution solution = new Solution();
        List<Integer> ans = solution.countSmaller(new int[]{7, 8, 5, 2, 6, 1, 1});
        Assert.assertEquals("[5, 5, 3, 2, 2, 0, 0]", ans.toString());
    }

}