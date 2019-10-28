package code.code100.question061;

import code.code50.question002.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 链接：https://leetcode-cn.com/problems/rotate-list
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/16
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode s = head;
        ListNode e = head;
        ListNode ans;
        int count = 0;
        while (k > 0 && e.next != null) {
            e = e.next;
            count++;
            k--;
        }
        if (k == 0) {
            while (e.next != null) {
                e = e.next;
                s = s.next;
            }
        } else {
            return rotateRight(head, (k + count) % (count + 1));
        }
        e.next = head;
        ans = s.next;
        s.next = null;
        return ans;
    }
}
