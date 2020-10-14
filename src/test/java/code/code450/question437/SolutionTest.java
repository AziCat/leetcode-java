package code.code450.question437;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void pathSum() {
        TreeNode root = TreeNode.build(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.pathSum(root, 8));
    }

    @Test
    public void pathSum1() {
        TreeNode root = TreeNode.build(new Integer[]{1, null, 2, null, 3, null, 4, null, 5});
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.pathSum(root, 3));
    }
}