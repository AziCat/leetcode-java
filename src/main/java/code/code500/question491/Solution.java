package code.code500.question491;

import java.util.*;

/**
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * <p>
 * 示例:
 * <p>
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 * <p>
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/8/25
 */
public class Solution {
    private List<List<Integer>>[] cache;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.cache = new List[nums.length];
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> sub = cache[i];
            if (null == sub) {
                sub = dfs(nums, i);
            }
            if (!set.contains(nums[i])) {
                ans.addAll(sub);
                set.add(nums[i]);
            }
        }
        return ans;
    }

    private List<List<Integer>> dfs(int[] nums, int i) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> sub = new ArrayList<>();
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] >= nums[i] && !set.contains(nums[j])) {
                if (null == cache[j]) {
                    dfs(nums, j);
                }
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                sub.add(list);
                cache[j].forEach(subList -> {
                    List<Integer> l2 = new ArrayList<>();
                    l2.add(nums[i]);
                    l2.addAll(subList);
                    sub.add(l2);
                });
                set.add(nums[j]);
            }
        }
        cache[i] = sub;
        return sub;
    }
}
