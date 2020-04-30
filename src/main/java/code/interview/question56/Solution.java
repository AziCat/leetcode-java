package code.interview.question56;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/4/28
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(8 ^ -8);
    }

    /**
     * 异或操作
     * 相同的两个数异或为0，最后得出A xor B = C
     * 假设数组[4,1,4,6]进行异或运算，最后得出1^6=7--->0001 ^ 0110 = 0111
     * 0111从右往左，第1位为1，说明A和B二进制位第1位不相同，所以把nums中二进制位1位为0和1分为两组
     * 0:[4,4,6] 1:[1]
     * 然后两个数组内部元素进行异或，得出6，1
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        //用于将所有的数异或起来
        int k = 0;

        for (int num : nums) {
            k ^= num;
        }

        //获得k中最低位的1
        int mask = 1;

        //不断左移mark中的1
        while ((k & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;

        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}
