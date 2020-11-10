package code.code450.question442;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * <p>
 * 找到所有出现两次的元素。
 * <p>
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * <p>
 * 示例：
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [2,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/10/19
 */
public class Solution {
    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> findDuplicates(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i - 1];
            if (num != i) {
                nums[i - 1] = -1;
                push(num, nums);
            }
        }
        return ans;
    }

    private void push(int position, int[] nums) {
        int num = nums[position - 1];
        if (num == position) {
            ans.add(num);
        } else {
            nums[position - 1] = position;
            if (num != -1) {
                push(num, nums);
            }
        }
    }
}
