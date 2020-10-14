package code.code450.question429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yan
 * @version 1.0
 * @date 2020/9/9
 */
public class Solution {
    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (null != root) {
            LinkedList<Node> rootQueue = new LinkedList<>();
            rootQueue.offer(root);
            LinkedList<Node> childQueue = new LinkedList<>();
            bfs(rootQueue, childQueue);
        }

        return ans;
    }

    private void bfs(LinkedList<Node> rootQueue, LinkedList<Node> childQueue) {
        List<Integer> sub = new ArrayList<>();
        while (!rootQueue.isEmpty()) {
            Node root = rootQueue.poll();
            sub.add(root.val);
            if (null != root.children) {
                for (Node child : root.children) {
                    childQueue.offer(child);
                }
            }
        }
        ans.add(sub);
        if (!childQueue.isEmpty()) {
            bfs(childQueue, rootQueue);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
