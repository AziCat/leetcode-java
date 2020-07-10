package code.code400.question368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 * <p>
 * 如果有多个目标子集，返回其中任何一个均可。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 * 示例 2:
 * <p>
 * 输入: [1,2,4,8]
 * 输出: [1,2,4,8]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/7/3
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //先排序
        Arrays.sort(nums);
        //dp[i]记录以nums[i]结尾的最大子集数
        int[] dp = new int[nums.length];
        //position[i]记录以nums[i]结尾最大子集的上一个数位置
        int[] position = new int[nums.length];
        Arrays.fill(position,-1);
        int maxPosition = -1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i ; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        position[i] = j;
                        if (dp[i] > max) {
                            max = dp[i];
                            maxPosition = i;
                        }
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (max > 0) {
            ans.add(0, nums[maxPosition]);
            maxPosition = position[maxPosition];
            max--;
        }
        return ans;
    }
}
