package code.code150.question111;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void minDepth() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{3, 9, 20, null, null, 15, 7});
        Assert.assertEquals(2, solution.minDepth(root));
    }

    @Test
    public void minDepth1() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{1, 1, null, 1});
        Assert.assertEquals(3, solution.minDepth(root));
    }

}