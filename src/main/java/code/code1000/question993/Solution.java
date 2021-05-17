package code.code1000.question993;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2021/5/17
 */
public class Solution {
    private int xParent = 0;
    private int yParent = 0;
    private int xDeep = 0;
    private int yDeep = 0;

    /**
     * 0ms
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) {
            return false;
        }
        return isCousins(root.val, root.left, x, y, 1)
                || isCousins(root.val, root.right, x, y, 1);
    }

    private boolean isCousins(int p, TreeNode node, int x, int y, int deep) {
        if (null == node) {
            return false;
        }
        //当前层级匹配到一个目标，没必要向下找另一个目标，因为x，y是同级的
        if (node.val == x) {
            xParent = p;
            xDeep = deep;
            if (yParent != 0) {
                return xParent != yParent && xDeep == yDeep;
            } else {
                return false;
            }
        }
        if (node.val == y) {
            yParent = p;
            yDeep = deep;
            if (xParent != 0) {
                return xParent != yParent && xDeep == yDeep;
            } else {
                return false;
            }
        }
        return isCousins(node.val, node.left, x, y, deep + 1)
                || isCousins(node.val, node.right, x, y, deep + 1);

    }


    /**
     * 2ms
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins1(TreeNode root, int x, int y) {
        //因为二叉树的节点数介于 2 到 100 之间。parent记录父节点的值
        int[] parent = new int[101];
        List<TreeNode> list = Collections.singletonList(root);
        return check(list, parent, x, y);
    }

    private boolean check(List<TreeNode> list, int[] parent, int x, int y) {
        if (parent[x] != 0) {
            return parent[y] != 0 && parent[x] != parent[y];
        }
        if (parent[y] != 0) {
            return parent[x] != 0 && parent[x] != parent[y];
        }
        List<TreeNode> nextStep = new ArrayList<>();
        list.forEach(node -> {
            if (null != node.left) {
                parent[node.left.val] = node.val;
                nextStep.add(node.left);
            }
            if (null != node.right) {
                parent[node.right.val] = node.val;
                nextStep.add(node.right);
            }
        });
        return !nextStep.isEmpty() && check(nextStep, parent, x, y);
    }


}
