package code.code50.question025;

import common.ListNode;

import java.util.LinkedList;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 * <p>
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/18
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode ans = pre;
        ListNode start = pre;
        ListNode end = pre;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (null == end) {
                break;
            }
            ListNode next = end.next;
            end.next = null;
            start = pre.next;
            pre.next = reverse(start);
            pre = start;
            end = start;
            start.next = next;
        }
        return ans.next;
    }

    private ListNode reverse(ListNode start) {
        ListNode pre = null;
        ListNode cur = start;
        while (null != cur) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private LinkedList<ListNode> queue = new LinkedList<>();

    /**
     * 返回值：反转后的子链，或者是长度未满k的未翻转子链
     * <p>
     * 调用单元：往长度为k的队列中按顺序存放节点。
     * 当队列满了，从队列最后一个节点开始翻转链表，翻转到最后一个节点时，指向下一个翻转子链；
     * 若队列保存了当前链表最后一个节点时仍未满，返回队列第一个节点。
     * <p>
     * 终止条件：head为空；队列保存了当前链表最后一个节点时仍未满
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup_(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        while (queue.size() != k && head != null) {
            queue.add(head);
            head = head.next;
        }
        if (queue.size() == k) {
            ListNode node = new ListNode(0);
            ListNode ans = node;
            while (!queue.isEmpty()) {
                node.next = queue.pollLast();
                node = node.next;
            }
            node.next = reverseKGroup(head, k);
            return ans.next;

        } else {
            return queue.pollFirst();
        }
    }
}
