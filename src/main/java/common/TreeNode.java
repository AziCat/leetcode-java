package common;

import java.util.*;

/**
 * Definition for a binary tree node
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

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
        if (nodes.length == 0) {
            return null;
        }
        List<TreeNode> firstLayer = new ArrayList<>();
        firstLayer.add(new TreeNode(nodes[0]));
        build(firstLayer, 1, nodes);
        return firstLayer.get(0);
    }

    /**
     * [1,2,3,null]
     *
     * @param data
     * @return
     */
    public static TreeNode build(String data) {
        data = data.replace("[", "").replace("]", "");
        String[] dataArr = data.split(",");
        Integer[] nodes = new Integer[dataArr.length];
        for (int i = 0; i < dataArr.length; i++) {
            if (!"null".equals(dataArr[i])) {
                nodes[i] = Integer.parseInt(dataArr[i]);
            }
        }
        return build(nodes);
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

    public static void toList(List<TreeNode> nodes, List<Integer> ans) {
        List<TreeNode> child = new ArrayList<>();
        int nullCount = 0;
        for (TreeNode node : nodes) {
            if (node != null) {
                ans.add(node.val);
                child.add(node.left);
                child.add(node.right);
            } else {
                nullCount++;
                ans.add(null);
            }
        }
        if (nullCount != nodes.size()) {
            toList(child, ans);
        } else {
            while (!ans.isEmpty() && ans.get(ans.size() - 1) == null) {
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static String toString(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        if (null != root) {
            serialize(Collections.singletonList(root), nodeList);
        }
        while (nodeList.get(nodeList.size() - 1) == null) {
            nodeList.remove(nodeList.size() - 1);
        }
        return nodeList.toString().replace(" ", "");
    }

    public static void serialize(List<TreeNode> layer, List<Integer> nodeList) {
        List<TreeNode> nextLayer = new ArrayList<>();
        for (TreeNode node : layer) {
            if (null != node) {
                nodeList.add(node.val);
                nextLayer.add(node.left);
                nextLayer.add(node.right);
            } else {
                nodeList.add(null);
            }
        }
        if (!nextLayer.isEmpty()) {
            serialize(nextLayer, nodeList);
        }

    }

    public static void main(String[] args) {
        Integer[] nodes = {5, 4, 7, 3, null, 2, null, -1, null, 9};
        TreeNode treeNode = build(nodes);
        System.out.println(TreeNode.toString(treeNode));
    }
}
