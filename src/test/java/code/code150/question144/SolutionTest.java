package code.code150.question144;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void preorderTraversal() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{1, null, 2, 3});
        List<Integer> ans = solution.preorderTraversal(root);
        Assert.assertEquals("[1, 2, 3]", ans.toString());
    }

}