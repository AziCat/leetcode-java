package code.code150.question129;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void sumNumbers() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{4, 9, 0, 5, 1});
        Assert.assertEquals(1026, solution.sumNumbers(root));
    }

    @Test
    public void sumNumbers1() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{4, 9, 0, 5, 1, null, null, null, 7});
        Assert.assertEquals(5488, solution.sumNumbers(root));
    }

}