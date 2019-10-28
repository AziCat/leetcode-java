package code.code100.question082;

import code.code50.question002.ListNode;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/23
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        Integer i = null;
        while (head != null) {
            if (head.next == null) {
                if (i == null || head.val != i) {
                    cur.next = head;
                    cur = head;
                }
            } else {
                if (head.val != head.next.val && (i == null || head.val != i)) {
                    cur.next = head;
                    cur = head;
                } else {
                    i = head.val;
                    cur.next = null;
                }
            }
            head = head.next;
        }
        return ans.next;
    }
}
