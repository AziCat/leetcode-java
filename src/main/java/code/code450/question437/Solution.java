package code.code450.question437;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/10/13
 */
public class Solution {

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        //key-前缀和，value-出现次数
        prefixSumMap.put(0, 1);
        return pathSum(root, sum, prefixSumMap, 0);
    }

    private int pathSum(TreeNode root, int target, Map<Integer, Integer> prefixSumMap, int curSum) {
        int ans = 0;
        if (null != root) {
            //当前路径累加
            curSum += root.val;
            //当curSum-target存在于hash时说明有解
            ans += prefixSumMap.getOrDefault(curSum - target, 0);
             //添加到hash中
            prefixSumMap.put(curSum, prefixSumMap.getOrDefault(curSum, 0) + 1);
            //计算左右子节点
            ans += pathSum(root.left, target, prefixSumMap, curSum);
            ans += pathSum(root.right, target, prefixSumMap, curSum);
            //计算完移除当前路径
            prefixSumMap.put(curSum, prefixSumMap.get(curSum) - 1);
        }
        return ans;
    }

    /**
     * 双重递归
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum1(TreeNode root, int sum) {
        int ans = 0;
        if (null != root) {
            ans += dfs(root, sum);
            ans += pathSum1(root.left, sum);
            ans += pathSum1(root.right, sum);

        }

        return ans;
    }

    /**
     * 包含root.val等于sum
     *
     * @param root
     * @param sum
     * @return
     */
    private int dfs(TreeNode root, int sum) {
        int ans = 0;
        if (null != root) {
            if (root.val == sum) {
                ans++;
            }
            ans += dfs(root.left, sum - root.val);
            ans += dfs(root.right, sum - root.val);
        }
        return ans;
    }
}
