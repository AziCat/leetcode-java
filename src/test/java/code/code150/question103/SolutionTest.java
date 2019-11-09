package code.code150.question103;

import common.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void zigzagLevelOrder() throws Exception {
        TreeNode root = TreeNode.build(new Integer[]{3, 9, 20, null, null, 15, 7, 1, 2, 3, 4});
        Solution solution = new Solution();
        List ans = solution.zigzagLevelOrder(root);
        for (Object an : ans) {
            System.out.println(an.toString());
        }
    }

}