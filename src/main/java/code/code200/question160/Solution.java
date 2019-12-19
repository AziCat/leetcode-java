package code.code200.question160;

import common.ListNode;

import java.util.HashSet;

/**
 * 编写一个程序，找到两个单链表相交的起始节点
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/18
 */
public class Solution {
    /**
     * 定义两个指针分别从两端遍历，其中一个指针遍历到尾部时再指向另一边头部，当两个指针相等时返回
     * 抽象理解为两个人的速度一致，走的距离一样，那么两个人肯定同时到达终点
     * 1 ms
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = (pa == null) ? headB : pa.next;
            pb = (pb == null) ? headA : pb.next;
        }
        return pa;
    }

    /**
     * 记录已访问的节点，重复访问时返回
     * 17 ms
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        HashSet<ListNode> visited = new HashSet<>();
        while (headA != null || headB != null) {
            if (headA != null) {
                if (visited.contains(headA)) {
                    return headA;
                }
                visited.add(headA);
                headA = headA.next;
            }
            if (headB != null) {
                if (visited.contains(headB)) {
                    return headB;
                }
                visited.add(headB);
                headB = headB.next;
            }
        }
        return null;
    }
}
