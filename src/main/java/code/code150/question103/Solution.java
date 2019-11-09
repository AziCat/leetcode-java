package code.code150.question103;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 */
public class Solution {
    private List<List<Integer>> levelList = new ArrayList<>();

    /**
     * 根据question102修改
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root != null) {
            helper(root, 0);
        }
        return levelList;
    }

    private void helper(TreeNode root, int level) {
        if (levelList.size() == level) {
            levelList.add(new ArrayList<>());
        }
        if (root != null) {
            if (level % 2 == 0) {
                levelList.get(level).add(root.val);
            } else {
                //逆序从列表头部插入
                levelList.get(level).add(0, root.val);
            }

            if (null != root.left) {
                helper(root.left, level + 1);
            }
            if (null != root.right) {
                helper(root.right, level + 1);
            }
        }
    }
}
