package code.code100.question092;

import common.ListNode;

import java.util.Stack;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/25
 */
public class Solution {
    /**
     * 使用栈
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int curP = 1;
        if (m == n) {
            return head;
        }
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode begin = ans ;
        ListNode end = null;
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            if (curP < m ) {
                begin = cur;
            } else if (curP > n && end == null) {
                end = cur;
            }
            if (curP >= m && curP <= n) {
                stack.push(cur);
            }
            cur = cur.next;
            curP++;
        }
        while (!stack.isEmpty()) {
            begin.next = stack.pop();
            begin = begin.next;
        }
        begin.next = end;
        return ans.next;
    }
}
