package code.code1500.question1486;

/**
 * 给你两个整数，n 和 start 。
 * <p>
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * <p>
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-operation-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2021/5/7
 */
public class Solution {
    /**
     * 简单模拟
     *
     * @param n
     * @param start
     * @return
     */
    public int xorOperation(int n, int start) {
        int i = 0;
        int ans = start;
        while (++i < n) {
            ans = ans ^ (start + 2 * i);
        }

        return ans;
    }
}
