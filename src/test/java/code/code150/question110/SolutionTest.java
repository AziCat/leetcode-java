package code.code150.question110;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void isBalanced() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{3, 9, 20, null, null, 15, 7});
        Assert.assertTrue(solution.isBalanced(root));
    }

    @Test
    public void isBalanced1() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4});
        Assert.assertFalse(solution.isBalanced(root));
    }

    @Test
    public void isBalanced2() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4});
        Assert.assertFalse(solution.isBalanced(root));
    }

}