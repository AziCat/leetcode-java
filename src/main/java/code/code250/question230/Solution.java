package code.code250.question230;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/13
 */
public class Solution {
    private int counter = 0;
    private boolean isFind = false;
    private int ans = 0;

    /**
     * 利用二叉搜索树的特性，中序遍历到第k个
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        find(root, k);
        return ans;
    }

    private void find(TreeNode root, int k) {
        if (root.left != null) {
            find(root.left, k);
        }
        if (!isFind) {
            counter++;
            if (counter == k) {
                isFind = true;
                ans = root.val;
            } else {
                if (root.right != null) {
                    find(root.right, k);
                }
            }
        }
    }


    private LinkedList<Integer> list = new LinkedList<>();

    /**
     * 生成有序链表
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest1(TreeNode root, int k) {
        buildList(root);
        return list.get(k - 1);
    }

    private void buildList(TreeNode root) {
        if (null != root) {
            buildList(root.left);
            list.addLast(root.val);
            buildList(root.right);
        }
    }
}
