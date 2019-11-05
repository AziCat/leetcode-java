package code.code100.question094;

import common.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void inorderTraversal() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{1, null, 2, 3});
        List<Integer> ans = solution.inorderTraversal(root);
        System.out.println(ans);
    }

}