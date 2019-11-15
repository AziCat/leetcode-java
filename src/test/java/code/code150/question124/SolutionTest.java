package code.code150.question124;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void maxPathSum() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{-10, 45, 20, null, null, 15, 7});
        Assert.assertEquals(70, solution.maxPathSum(root));
    }

    @Test
    public void maxPathSum1() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{-10, 9, 20, null, null, 15, 7});
        Assert.assertEquals(42, solution.maxPathSum(root));
    }

    @Test
    public void maxPathSum2() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{-10, -9, -20, null, null, 3, -7});
        Assert.assertEquals(3, solution.maxPathSum(root));
    }

    @Test
    public void maxPathSum3() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{-10, -9, -20, null, null, -3, -7});
        Assert.assertEquals(-3, solution.maxPathSum(root));
    }

}