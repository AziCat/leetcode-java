package code.code2000.question1995;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/25
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (null != root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (null != node) {
                    sb.append(node.val).append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    sb.append("null,");
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (null != data && data.length() > 0) {
            String[] arr = data.split(",");
            LinkedList<TreeNode> queue = new LinkedList<>();

            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            queue.add(root);
            int i = 1;
            while (i < arr.length) {
                TreeNode node = queue.poll();
                if ("null".equals(arr[i])) {
                    node.left = null;
                } else {
                    node.left = new TreeNode(Integer.parseInt(arr[i]));
                    queue.add(node.left);
                }
                i++;
                if ("null".equals(arr[i])) {
                    node.right = null;
                } else {
                    node.right = new TreeNode(Integer.parseInt(arr[i]));
                    queue.add(node.right);
                }
                i++;
            }
            return root;
        }
        return null;
    }
}
