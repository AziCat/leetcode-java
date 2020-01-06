package code.code250.question206;

import common.ListNode;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/1/6
 */
public class Solution {
    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode(0);
        reverseList(head, pre);
        return pre.next;
    }

    public ListNode reverseList(ListNode head, ListNode pre) {
        if (null != head) {
            if (head.next == null) {
                pre.next = head;
            }else {
                ListNode reverseNode = reverseList(head.next, pre);
                head.next = null;
                reverseNode.next = head;
            }
        }
        return head;
    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tempPre = cur.next;
            if (tempPre == null) {
                cur.next = pre;
                return cur;
            }
            ListNode tempCur = cur.next.next;
            cur.next.next = cur;
            cur.next = pre;
            if (tempCur == null) {
                return tempPre;
            }
            cur = tempCur;
            pre = tempPre;
        }
        return null;
    }
}
