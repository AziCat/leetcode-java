package code.code150.question101;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void isSymmetric() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isSymmetric(TreeNode.build(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
    }

    @Test
    public void isSymmetric1() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isSymmetric(TreeNode.build(new Integer[]{1, 2, 2, 3, 4, 4, 3, null, null, 2, null, null, 2, null, null, 4, 5, 5, 4})));
    }

    @Test
    public void isSymmetric2() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isSymmetric(TreeNode.build(new Integer[]{1,2,2,null,3,null,3})));
    }
}