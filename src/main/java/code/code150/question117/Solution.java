package code.code150.question117;

import common.Node;

/**
 * 给定一个二叉树
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public Node connect(Node root) {
        if (null != root) {
            Node level = root, cur = root;
            while (level != null) {
                if (cur.left != null) {
                    if (cur.right != null) {
                        cur.left.next = cur.right;
                    }else {
                        cur.left.next = next(cur.next);
                    }
                }
                if (cur.right != null) {
                    cur.right.next = next(cur.next);
                }
                if (cur.next == null) {
                    level = next(level);
                    cur = level;
                }else {
                    cur = cur.next;
                }
            }
        }
        return root;
    }


    private Node next(Node level) {
        if (null != level) {
            if (null != level.left) {
                return level.left;
            } else if (null != level.right) {
                return level.right;
            } else {
                return next(level.next);
            }
        }
        return null;
    }
}
