package code.code350.question315;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/3/13
 */
public class Solution {
    /**
     * 构建搜索二叉树
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        TreeNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insertNode(root, ans, nums[i],0);
        }
        return ans;
    }

    private TreeNode insertNode(TreeNode root, List<Integer> ans, int val,int counter) {
        if (null == root) {
            root = new TreeNode(val);
            ans.add(0, counter);
        }else {
            if (val <= root.val) {
                //插入左子树
                root.leftCount+=1;
                root.left = insertNode(root.left, ans, val, counter);
            }else {
                counter+=root.leftCount+1;
                root.right = insertNode(root.right, ans, val, counter);
            }
        }
        return root;
    }

    class TreeNode {
        public int val;
        //左子树节点数
        public int leftCount = 0;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
