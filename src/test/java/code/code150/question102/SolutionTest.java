package code.code150.question102;

import common.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void levelOrder() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> ans = solution.levelOrder(root);
        for (List<Integer> an : ans) {
            System.out.println(an.toString());
        }
    }

}