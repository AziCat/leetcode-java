package code.code200.question164;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * <p>
 * 如果数组元素个数小于 2，则返回 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 * <p>
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 * <p>
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-gap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/20
 */
public class Solution {
    public class Bucket {
        public int max = Integer.MIN_VALUE;
        public int min = Integer.MAX_VALUE;
    }

    /**
     * 需要线性时间复杂度，用桶排序，设最大间隔为maxD
     * 假设极端情况下，排序后的数组间隔都相等，则 d = (max-min)/(n-1)
     * 得出所有情况下有 maxD >= d = (max-min)/(n-1)，现在准备(max-min)/d + 1个桶
     * 0号桶存放范围是[min,min+d)的值
     * 1号桶存放范围是[min+d,min+2d)的值
     * ....
     * (max-min)/d号桶存放范围是[min+n*d,min+(n+1)*d)
     * (max-min)/d + 1号直接放max值
     * 因为桶已经排好序，所以计算每个非空桶的最小值 减 上一个非空桶的最大值，最大值为结果d
     *
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        //计算平均间隔
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        if (max == min) {
            return 0;
        }
        int d = (max - min) / (nums.length - 1);
        d = d == 0 ? 1 : d;
        //创建桶
        int bucketSize = (max - min) / d + 1;
        Bucket[] buckets = new Bucket[bucketSize];
        for (int num : nums) {
            //计算要存放在哪个桶
            int locationIndex;
            if (num == min) {
                locationIndex = 0;
            } else if (num == max) {
                locationIndex = bucketSize - 1;
            } else {
                locationIndex = (num - min) / d;
            }
            if (buckets[locationIndex] == null) {
                buckets[locationIndex] = new Bucket();
            }
            //存放数据
            buckets[locationIndex].min = Math.min(buckets[locationIndex].min, num);
            buckets[locationIndex].max = Math.max(buckets[locationIndex].max, num);
        }
        Bucket pre = buckets[0];
        int maxD = d;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i] != null) {
                maxD = Math.max(maxD, buckets[i].min - pre.max);
                pre = buckets[i];
            }
        }
        return maxD;
    }
}
