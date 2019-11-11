package code.code150.question109;

import common.ListNode;
import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void sortedListToBST() throws Exception {
        Solution solution = new Solution();
        ListNode listNode = ListNode.build("-10->-3->0->5->9");
        TreeNode root = solution.sortedListToBST(listNode);
        List<Integer> ans = new ArrayList<>();
        TreeNode.toList(Collections.singletonList(root), ans);
        System.out.println(ans.toString());
    }

}