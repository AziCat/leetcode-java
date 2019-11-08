package code.code100.question098;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void isValidBST() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isValidBST(TreeNode.build(new Integer[]{5, 1, 4, null, null, 3, 6})));
    }

    @Test
    public void isValidBST3() throws Exception {
        Solution solution = new Solution();
        Assert.assertFalse(solution.isValidBST(TreeNode.build(new Integer[]{10, 5, 15, null, null, 6, 20})));
    }

    @Test
    public void isValidBST1() throws Exception {
        Solution solution = new Solution();
        Assert.assertTrue(solution.isValidBST(TreeNode.build(new Integer[]{2, 1, 3})));
    }

}