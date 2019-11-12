package common;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
    public static Node build(Integer[] nodes) {
        List<Node> firstLayer = new ArrayList<>();
        firstLayer.add(new Node(nodes[0],null,null,null));
        build(firstLayer, 1, nodes);
        return firstLayer.get(0);
    }

    private static void build(List<Node> upLayerList, int st, Integer[] nodes) {
        if (st == nodes.length) {
            return;
        }
        List<Node> layerList = new ArrayList<>();
        for (Node treeNode : upLayerList) {
            if (null != treeNode) {
                if (st == nodes.length) {
                    break;
                }
                if (nodes[st] != null) {
                    Node left = new Node(nodes[st++],null,null,null);
                    layerList.add(left);
                    treeNode.left = left;
                } else {
                    st++;
                }
                if (st == nodes.length) {
                    break;
                }
                if (nodes[st] != null) {
                    Node right = new Node(nodes[st++],null,null,null);
                    layerList.add(right);
                    treeNode.right = right;
                } else {
                    st++;
                }
            }
        }
        build(layerList, st, nodes);
    }
}
