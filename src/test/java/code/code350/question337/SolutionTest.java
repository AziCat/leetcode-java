package code.code350.question337;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void rob() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.rob(null));
    }

    @Test
    public void rob1() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{3, 4, 5, 1, 3, null, 1});
        Assert.assertEquals(9, solution.rob(root));
    }

    @Test
    public void rob2() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{3, 2, 3, null, 3, null, 1});
        Assert.assertEquals(7, solution.rob(root));
    }
}