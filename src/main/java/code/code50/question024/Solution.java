package code.code50.question024;

import code.code50.question002.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/18
 */
public class Solution {
    /**
     * 1 ms	34.8 MB
     * <p>
     * 使用递归
     * 返回值：完成交换的子链
     * 调用单元：head指向后面完成交换的子链，next指向head
     * 终止条件：head为空或者next为空
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    /**
     * 1 ms	34.9 MB
     *
     * @param head
     * @return
     */
    public ListNode swapPairs__(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        first.next = second.next;
        second.next = first;
        head = second;
        second = first.next;
        while (second != null && second.next != null) {
            first.next = second.next;
            second.next = second.next.next;
            first.next.next = second;
            first = second;
            second = second.next;
        }
        return head;
    }

    /**
     * 0 ms	35.1 MB
     *
     * @param head
     * @return
     */
    public ListNode swapPairs_(ListNode head) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode cur = ans;
        ListNode[] arr = new ListNode[2];
        while (null != cur.next) {
            arr[0] = cur.next;
            arr[1] = cur.next.next;
            if (null != arr[1]) {
                cur.next = arr[1];
                arr[0].next = arr[1].next;
                arr[1].next = arr[0];
            }
            cur = arr[0];
        }
        return ans.next;
    }
}
