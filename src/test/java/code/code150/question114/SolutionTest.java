package code.code150.question114;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void flatten() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{1, 2, 5, 3, 4, null, 6});
        solution.flatten(root);
        List<Integer> ans = new ArrayList<>();
        TreeNode.toList(Collections.singletonList(root), ans);
        Assert.assertEquals("[1, null, 2, null, 3, null, 4, null, 5, null, 6]", ans.toString());
    }

    @Test
    public void flatten1() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{1, 2, null, 3});
        solution.flatten(root);
        List<Integer> ans = new ArrayList<>();
        TreeNode.toList(Collections.singletonList(root), ans);
        Assert.assertEquals("[1, null, 2, null, 3]", ans.toString());
    }

}