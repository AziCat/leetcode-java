package code.code150.question137;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yjh
 * @since 2021/4/30
 */
public class Solution {
    /**
     * 使用位运算统计
     * 假设数组为[3,3,3,5]
     * 对应二进制位为，每位相加，出现3次的数的对应位置的和肯定是3的倍数
     * 3:0 0 0 0 0 1 1
     * 3:0 0 0 0 0 1 1
     * 3:0 0 0 0 0 1 1
     * 5:0 0 0 0 1 0 1
     *   0 0 0 0 1 3 4
     *
     * 对每位的和除以3求余得出
     * 0 0 0 0 1 0 1 = 5
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        //32位数组存放二进制位
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
