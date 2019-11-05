package code.code100.question086;

import common.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 链接：https://leetcode-cn.com/problems/partition-list
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/24
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode ans1 = new ListNode(0);
        ListNode ans2 = new ListNode(0);
        ListNode cur = head;
        ListNode lt = null;
        ListNode gt = null;
        while (cur != null) {
            if (cur.val < x) {
                if (lt == null) {
                    lt = cur;
                    ans1.next = lt;
                } else {
                    lt.next = cur;
                    lt = lt.next;
                }
                if (gt != null) {
                    gt.next = null;
                }
            } else {
                if (gt == null) {
                    gt = cur;
                    ans2.next = gt;
                } else {
                    gt.next = cur;
                    gt = gt.next;
                }
                if (lt != null) {
                    lt.next = null;
                }
            }
            cur = cur.next;
        }
        if (lt != null) {
            lt.next = ans2.next;
        } else {
            ans1.next = ans2.next;
        }
        return ans1.next;
    }
}
