package code.code450.question430;

/**
 * @author yan
 * @version 1.0
 * @date 2020/9/10
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head = new Node();
        head.val = 1;
        head.child = new Node();
        head.child.val = 2;
        head.child.child = new Node();
        head.child.child.val = 3;
        Node node = solution.flatten(head);
        System.out.println(node);
    }

    public Node flatten(Node head) {
        if (null != head) {
            head = helper(head);
            head.prev = null;
        }
        return head;
    }

    public Node helper(Node head) {
        Node pre = new Node();
        Node tail = new Node();
        pre.next = head;
        while (head != null) {
            Node next = head.next;
            if (head.child != null) {
                Node flattenChild = helper(head.child);
                head.next = flattenChild;
                head.child = null;
                if (null != next) {
                    next.prev = flattenChild.prev;
                }
                flattenChild.prev.next = next;
                next = flattenChild.prev;
                flattenChild.prev = head;
            }
            if (next == null) {
                tail = head;
            }
            head = next;

        }
        pre.next.prev = tail;
        return pre.next;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

}
