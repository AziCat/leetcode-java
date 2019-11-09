package code.code150.question106;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void buildTree() throws Exception {
        Solution solution = new Solution();
        int[] postOrder = new int[]{4, 7, 8, 5, 2, 9, 6, 3, 1};
        int[] inOrder = new int[]{4, 2, 7, 5, 8, 1, 6, 9, 3};
        TreeNode root = solution.buildTree(inOrder, postOrder);
        List<Integer> ans = new ArrayList<>();
        TreeNode.toList(Collections.singletonList(root), ans);
        Assert.assertEquals("[1, 2, 3, 4, 5, 6, null, null, null, 7, 8, null, 9]", ans.toString());
    }

}