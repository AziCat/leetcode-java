package code.code100.question095;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 */
public class Solution {
    /**
     * 思路：当i做根节点时，左子树由1~i-1构成，右子树由i+1~n构成
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int s, int e) {
        List<TreeNode> subList = new ArrayList<>();
        if (s > e) {
            subList.add(null);
        } else {
            for (int i = s; i <= e; i++) {
                List<TreeNode> leftTreeList = generateTrees(s, i - 1);
                List<TreeNode> rightTreeList = generateTrees(i + 1, e);
                for (TreeNode left : leftTreeList) {
                    for (TreeNode right : rightTreeList) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        subList.add(root);
                    }
                }
            }
        }
        return subList;
    }
}
