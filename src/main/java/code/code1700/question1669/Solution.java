package code.code1700.question1669;

import common.ListNode;

/**
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * <p>
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-in-between-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2023/1/30
 */
public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head2 = list2;
        ListNode tail2 = list2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        ListNode preANode = list1;

        for (int i = 0; i < a - 1; i++) {
            preANode = preANode.next;
        }
        ListNode aNode = preANode.next;
        preANode.next = head2;


        ListNode bNode = aNode;
        for (int i = 0; i < b - a; i++) {
            bNode = bNode.next;
        }
        tail2.next = bNode.next;
        bNode.next = null;

        return list1;
    }
}
