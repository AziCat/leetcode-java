package code.code100.question099;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    TreeNode root = TreeNode.build(new Integer[]{2, 1, 30, null, null, 28, 31, 27, 29});

    @Test
    public void recoverTree() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{31, 1, 30, null, null, 28, 2, 27, 29});
        List<Integer> list = new ArrayList<>();
        solution.recoverTree(root);
        TreeNode.toList(Collections.singletonList(root), list);
        Assert.assertEquals("[2, 1, 30, null, null, 28, 31, 27, 29]", list.toString());
    }

    @Test
    public void recoverTree1() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{2, 1, 30, null, null, 28, 31, 29, 27});
        solution.recoverTree(root);
        List<Integer> list = new ArrayList<>();
        TreeNode.toList(Collections.singletonList(root), list);
        Assert.assertEquals("[2, 1, 30, null, null, 28, 31, 27, 29]", list.toString());
    }

    @Test
    public void recoverTree2() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{2, 1, 30, null, null, 29, 31, 27, 28});
        List<Integer> list = new ArrayList<>();
        solution.recoverTree(root);
        TreeNode.toList(Collections.singletonList(root), list);
        Assert.assertEquals("[2, 1, 30, null, null, 28, 31, 27, 29]", list.toString());
    }

    @Test
    public void recoverTree3() throws Exception {
        Solution solution = new Solution();
        TreeNode root = TreeNode.build(new Integer[]{2, 30, 1, null, null, 28, 31, 27, 29});
        List<Integer> list = new ArrayList<>();
        solution.recoverTree(root);
        TreeNode.toList(Collections.singletonList(root), list);
        Assert.assertEquals("[2, 1, 30, null, null, 28, 31, 27, 29]", list.toString());
    }
}