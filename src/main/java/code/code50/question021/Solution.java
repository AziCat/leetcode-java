package code.code50.question021;

import code.code50.question002.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/17
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        ListNode head = new ListNode(0);
        head.next = l1;
        ListNode ans = head;
        while (null != l1 && null != l2) {
            if (l1.val > l2.val) {
                head.next = l2;
                head = l2;
                l2 = l2.next;
                head.next = l1;
            } else {
                head.next = l1;
                head = l1;
                l1 = l1.next;
                head.next = l2;
            }
        }
        return ans.next;
    }
}
