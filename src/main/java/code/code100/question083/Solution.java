package code.code100.question083;

import code.code50.question002.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/23
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode ans = new ListNode(0);
        ListNode slow = ans;
        ListNode fast = head;
        while (fast.next != null) {
            if (fast.val != fast.next.val) {
                slow.next = fast;
                fast = fast.next;
                slow = slow.next;
                slow.next = null;
            } else {
                fast = fast.next;
            }

        }
        if (fast.val == 0 || slow.val != fast.val) {
            slow.next = fast;
        }
        return ans.next;
    }
}
