package code.code250.question230;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void kthSmallest() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{3, 1, 4, null, 2});
        Assert.assertEquals(1, solution.kthSmallest(root, 1));
    }

    @Test
    public void kthSmallest1() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        Assert.assertEquals(3, solution.kthSmallest(root, 3));
    }

    @Test
    public void kthSmallest2() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        Assert.assertEquals(5, solution.kthSmallest(root, 5));
    }
}