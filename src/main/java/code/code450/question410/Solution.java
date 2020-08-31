package code.code450.question410;

/**
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 * <p>
 * 注意:
 * 数组长度 n 满足以下条件:
 * <p>
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 * <p>
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 * <p>
 * 输出:
 * 18
 * <p>
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-largest-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/8/31
 */
public class Solution {
    /**
     * 当m=nums.length时，目标值为max(nums[0]...nums[nums.length-1])
     * 当m=1时，目标值为sum(nums[0]..nums[nums.length-1])
     * target肯定会在上述两个极限值之间，max<=target<=sum
     * 以max为左边界，sum为右边界，求出中值mid
     * nums各个值相加，当相加值大于mid，区间数+1，重置相加值为0，计算当前mid值有多少个区间
     * 调整左右边界和mid，直接得到target，使区间数等于m
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        long left = 0;
        long right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        //时间复杂度 O(nlogn)
        while (left < right) {
            long mid = (left + right) >>> 1;
            int c = 0;
            long temp = 0;
            for (int num : nums) {
                if (temp + num > mid) {
                    c++;
                    temp = 0;
                }
                temp += num;
            }
            //最终需要再 +1 ，因为最后的一个数组在上面的循环中不会被添加
            c++;
            //分割的子数组个数比目标个数大，那么意味着容量小的，需要调大容量
            if (c > m) {
                left = mid + 1;
            } else {
                //容量过大或者容量刚好
                right = mid;
            }
        }
        return (int) left;
    }
}
