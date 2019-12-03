package code.code150.question148;

import common.ListNode;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/3
 */
public class Solution {
    /**
     * 思路：快慢指针找到中间点把链表分成两部分，分别进行排序，然后再合并
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode mid = searchMid(head);
        if (mid.next == null) {
            //单个节点直接返回
            return head;
        }
        ListNode right = mid.next;
        //断开链表
        mid.next = null;

        ListNode sortLeft = sortList(head);
        ListNode sortRight = sortList(right);
        //合并
        return merge(sortLeft, sortRight);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                ListNode tmp = left.next;
                left.next = cur.next;
                cur.next = left;
                left = tmp;
            } else {
                ListNode tmp = right.next;
                right.next = cur.next;
                cur.next = right;
                right = tmp;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return dummy.next;
    }

    private ListNode searchMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }
}
