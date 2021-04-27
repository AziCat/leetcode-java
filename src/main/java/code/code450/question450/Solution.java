package code.code450.question450;

import common.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @version 1.0
 * @since 2021/4/22 11:53
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (null != root) {
            //删除root
            if (root.val == key) {
                //左子树不为空，返回左子树的最大节点leftMax，右子树设置为leftMax的右子树，返回左子树
                if (null != root.left) {
                    TreeNode leftMax = root.left;
                    while (leftMax.right != null) {
                        leftMax = leftMax.right;
                    }
                    leftMax.right = root.right;
                    return root.left;
                }else {
                    //左子树为空，直接返回右子树
                    return root.right;
                }
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            }else {
                root.right = deleteNode(root.right, key);
            }
        }
        return root;
    }
}
