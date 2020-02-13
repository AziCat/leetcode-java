package code.code250.question229;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 * <p>
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/12
 */
public class Solution {
    /**
     * 摩尔投票法的思路，每3个不同的数字相互抵消，获取剩余的两个，再记录这两个个数是否大于n/3
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int counter1 = 0, counter2 = 0, ans1 = Integer.MIN_VALUE, ans2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (counter1 != 0 && counter2 != 0 && num != ans1 && num != ans2) {
                counter1--;
                counter2--;
                ans1 = counter1 == 0 ? Integer.MIN_VALUE : ans1;
                ans2 = counter2 == 0 ? Integer.MIN_VALUE : ans2;
            } else {
                if ((counter1 == 0 && num != ans2) || num == ans1) {
                    counter1++;
                    ans1 = num;
                } else {
                    counter2++;
                    ans2 = num;
                }
            }
        }
        counter1 = 0;
        counter2 = 0;
        for (int num : nums) {
            if (num == ans1) {
                counter1++;
            } else if (num == ans2) {
                counter2++;
            }
        }
        if (counter1 > nums.length / 3) {
            ans.add(ans1);
        }
        if (counter2 > nums.length / 3) {
            ans.add(ans2);
        }
        return ans;
    }
}
