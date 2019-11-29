package code.code150.question138;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的深拷贝。
 *
 * @author yan
 * @version 1.0
 * @date 2019/11/28
 */
public class Solution {
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    private Map<Node, Node> cache = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        } else {
            Node copy = cache.get(head);
            if (null == copy) {
                copy = new Node();
                cache.put(head, copy);
                copy.val = head.val;
                copy.next = copyRandomList(head.next);
                copy.random = copyRandomList(head.random);
            }
            return copy;
        }
    }
}
