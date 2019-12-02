package code.code150.question143;

import common.ListNode;

import java.util.LinkedList;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/2
 */
public class Solution {
    /**
     * 快慢指针找出中间点分割成两个链，后段翻转，然后再拼接
     * 1->2->3->4->5->6
     * 1-2-3
     * 4-5-6
     * 翻转后段
     * 1-2-3
     * 6-5-4
     * 拼接
     * 1-6-2-5-3-4
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //找中点，链表分成两个
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        //第二个链表倒置
        newHead = reverseList(newHead);

        //链表节点依次连接
        while (newHead != null) {
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        head = head.next;

        tail.next = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        return tail;
    }

    /**
     * 递归 628 ms
     *
     * @param head
     */
    public void reorderList__(ListNode head) {
        if (head != null) {
            helper(head);
        }
    }

    public ListNode helper(ListNode head) {
        if (head.next != null) {
            ListNode end = head;
            while (end.next.next != null) {
                end = end.next;
            }
            if (head != end) {
                ListNode temp = end.next;
                end.next = null;
                temp.next = helper(head.next);
                head.next = temp;
            }
        }
        return head;
    }

    /**
     * 双向队列7ms
     *
     * @param head
     */
    public void reorderList_(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        while (head != null) {
            list.addLast(head);
            head = head.next;
        }
        boolean isTop = true;
        ListNode cur = new ListNode(0);
        while (!list.isEmpty()) {
            ListNode next;
            if (isTop) {
                next = list.pollFirst();
            } else {
                next = list.pollLast();
            }
            next.next = null;
            cur.next = next;
            cur = next;
            isTop = !isTop;
        }
    }
}
