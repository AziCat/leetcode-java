package code.code50.question023;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/18
 */
public class Solution {

    /**
     * 分治归并
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        } else if (len == 1) {
            return lists[0];
        }
        int mid = len >>> 1;
        ListNode[] l1 = new ListNode[mid];
        ListNode[] l2 = new ListNode[len - mid];
        System.arraycopy(lists, 0, l1, 0, mid);
        System.arraycopy(lists, mid, l2, 0, len - mid);
        return mergeNode(mergeKLists(l1), mergeKLists(l2));
    }

    private ListNode mergeNode(ListNode n1, ListNode n2) {
        ListNode pre = new ListNode(0);
        ListNode head = pre;
        while (n1 != null || n2 != null) {
            if (n1 == null) {
                pre.next = n2;
                n2 = n2.next;
            } else if (n2 == null) {
                pre.next = n1;
                n1 = n1.next;
            } else {
                if (n1.val < n2.val) {
                    pre.next = n1;
                    n1 = n1.next;
                } else {
                    pre.next = n2;
                    n2 = n2.next;
                }
            }
            pre = pre.next;
        }
        return head.next;
    }

    /**
     * 使用优先队列
     * 79 ms	40.9 MB
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists___(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for (ListNode node : lists) {
            if (null != node) {
                priorityQueue.add(node);
            }
        }
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while (!priorityQueue.isEmpty()) {
            cur.next = priorityQueue.poll();
            cur = cur.next;
            if (null != cur.next) {
                priorityQueue.add(cur.next);
            }
        }
        return ans.next;
    }

    /**
     * 两两合并-分治
     * 3 ms	39.5 MB
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists__(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        } else if (length == 1) {
            return lists[0];
        } else if (length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        } else {
            int mid = length / 2;
            ListNode[] l1s = new ListNode[mid];
            System.arraycopy(lists, 0, l1s, 0, mid);
            ListNode[] l2s = new ListNode[length - mid];
            System.arraycopy(lists, mid, l2s, 0, length - mid);
            return mergeTwoLists(mergeKLists(l1s), mergeKLists(l2s));
        }
    }

    /**
     * 两两合并
     * 301 ms	53.2 MB
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists_(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        } else if (length == 1) {
            return lists[0];
        } else {
            ListNode ans = null;
            for (ListNode list : lists) {
                ans = mergeTwoLists(ans, list);
            }
            return ans;
        }
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
