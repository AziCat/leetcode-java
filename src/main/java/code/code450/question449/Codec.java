package code.code450.question449;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @version 1.0
 * @since 2021/4/22 11:29
 */
public class Codec {
    // Encodes a tree to a single string.
    //todo 二叉搜索树可以用先序遍历
    public String serialize(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        if (null != root) {
            serialize(Collections.singletonList(root), nodeList);
        }
        while (!nodeList.isEmpty() && nodeList.get(nodeList.size() - 1) == null) {
            nodeList.remove(nodeList.size() - 1);
        }
        return nodeList.toString().replace(" ", "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        data = data.replace("[", "").replace("]", "");
        String[] dataArr = data.split(",");
        Integer[] nodes = new Integer[dataArr.length];
        for (int i = 0; i < dataArr.length; i++) {
            if (!"null".equals(dataArr[i])) {
                nodes[i] = Integer.parseInt(dataArr[i]);
            }
        }
        return deserialize(nodes);
    }

    private TreeNode deserialize(Integer[] nodes) {
        if (nodes.length == 0) {
            return null;
        }
        List<TreeNode> firstLayer = new ArrayList<>();
        firstLayer.add(new TreeNode(nodes[0]));
        deserialize(firstLayer, 1, nodes);
        return firstLayer.get(0);
    }

    private void deserialize(List<TreeNode> upLayerList, int st, Integer[] nodes) {
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
        deserialize(layerList, st, nodes);
    }

    private void serialize(List<TreeNode> layer, List<Integer> nodeList) {
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
}
