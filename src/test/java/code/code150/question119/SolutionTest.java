package code.code150.question119;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void getRow() throws Exception {
        Solution solution = new Solution();
        List<Integer> ans = solution.getRow(3);
        Assert.assertEquals("[1, 3, 3, 1]", ans.toString());
    }

}