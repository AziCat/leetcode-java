package code.code50.question019;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/17
 */
public class Solution {
    /**
     * 快慢双指针，快指针比慢指针快n个位置，当快指针遍历到底时，慢指针刚好到要删除的节点的上一个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode end = head;
        while (null != first.next) {
            if (n == 0) {
                end = end.next;
            } else {
                n--;
            }
            first = first.next;
        }
        if (n == 1) {
            return end.next;
        }
        end.next = end.next.next;
        return head;
    }

    /**
     * 单指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd__(ListNode head, int n) {
        ListNode t = new ListNode(0);
        t.next = head;
        ListNode first = head;
        int length = 1;
        while (null != first.next) {
            length++;
            first = first.next;
        }
        length -= n;
        first = t;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return t.next;
    }

    /**
     * 遍历一次把所有节点存放到ArrayList中
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd_(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        while (null != head.next) {
            head = head.next;
            list.add(head);
        }
        if (n == list.size()) {
            return list.get(0).next;
        } else if (n == 1) {
            list.get(list.size() - 2).next = null;
        } else {
            int l = list.size() - n - 1;
            int r = list.size() - n + 1;
            list.get(l).next = list.get(r);
        }
        return list.get(0);
    }
}
