package code.code150.question105;

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
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = solution.buildTree(preOrder, inOrder);
        List<Integer> ans = new ArrayList<>();
        TreeNode.toList(Collections.singletonList(root), ans);
        Assert.assertEquals("[3, 9, 20, null, null, 15, 7]", ans.toString());
    }

    @Test
    public void buildTree1() throws Exception {
        Solution solution = new Solution();
        int[] preOrder = new int[]{1, 2};
        int[] inOrder = new int[]{2, 1};
        TreeNode root = solution.buildTree(preOrder, inOrder);
        List<Integer> ans = new ArrayList<>();
        TreeNode.toList(Collections.singletonList(root), ans);
        Assert.assertEquals("[1, 2]", ans.toString());
    }

    @Test
    public void buildTree2() throws Exception {
        Solution solution = new Solution();
        int[] preOrder = new int[]{1, 2, 3};
        int[] inOrder = new int[]{3, 2, 1};
        TreeNode root = solution.buildTree(preOrder, inOrder);
        List<Integer> ans = new ArrayList<>();
        TreeNode.toList(Collections.singletonList(root), ans);
        Assert.assertEquals("[1, 2, null, 3]", ans.toString());
    }

    @Test
    public void buildTree3() throws Exception {
        Solution solution = new Solution();
        int[] preOrder = new int[]{1, 2, 4, 5, 7, 8, 3, 6, 9};
        int[] inOrder = new int[]{4, 2, 7, 5, 8, 1, 6, 9, 3};
        TreeNode root = solution.buildTree(preOrder, inOrder);
        List<Integer> ans = new ArrayList<>();
        TreeNode.toList(Collections.singletonList(root), ans);
        Assert.assertEquals("[1, 2, 3, 4, 5, 6, null, null, null, 7, 8, null, 9]", ans.toString());
    }

}