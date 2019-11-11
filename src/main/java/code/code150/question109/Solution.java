package code.code150.question109;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 */
public class Solution {
    /**
     * 可以用快慢双指针，快指针每次遍历两个节点，慢指针每次一个节点，当快指针走到尾时，慢指针刚好到达中间用于当作根节点
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        return null;
    }
    public TreeNode sortedListToBST_(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        return helper(nodes, 0, nodes.size() - 1);
    }

    private TreeNode helper(List<ListNode> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nodes.get(mid).val);
        root.left = helper(nodes, start, mid - 1);
        root.right = helper(nodes, mid + 1, end);
        return root;
    }
}
