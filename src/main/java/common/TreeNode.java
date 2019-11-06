package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 从数组构建树<p></p>
     * 数组如何表示树请查看：https://support.leetcode-cn.com/hc/kb/article/1194353/
     *
     * @param nodes
     * @return
     */
    public static TreeNode build(Integer[] nodes) {
        List<TreeNode> firstLayer = new ArrayList<>();
        firstLayer.add(new TreeNode(nodes[0]));
        build(firstLayer, 1, nodes);
        return firstLayer.get(0);
    }

    private static void build(List<TreeNode> upLayerList, int st, Integer[] nodes) {
        if (st == nodes.length) {
            return;
        }
        List<TreeNode> layerList = new ArrayList<>();
        for (TreeNode treeNode : upLayerList) {
            if (null != treeNode) {
                if (st == nodes.length) {
                    break;
                }
                if (nodes[st] != null) {
                    TreeNode left = new TreeNode(nodes[st++]);
                    layerList.add(left);
                    treeNode.left = left;
                } else {
                    st++;
                }
                if (st == nodes.length) {
                    break;
                }
                if (nodes[st] != null) {
                    TreeNode right = new TreeNode(nodes[st++]);
                    layerList.add(right);
                    treeNode.right = right;
                } else {
                    st++;
                }
            }
        }
        build(layerList, st, nodes);
    }

    public static void main(String[] args) {
        Integer[] nodes = {5, 4, 7, 3, null, 2, null, -1, null, 9};
        TreeNode treeNode = build(nodes);
        System.out.println(treeNode);
    }
}
