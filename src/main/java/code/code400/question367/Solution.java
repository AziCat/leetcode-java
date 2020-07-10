package code.code400.question367;

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/7/2
 */
public class Solution {
    /**
     * 使用二分法
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int s = 0, e = num, mid;
        while (s < e && s + 1 != e) {
            mid = (s + e) >>> 1;
            int i = num / mid;
            int j = num % mid;
            if (i == mid && j == 0) {
                return true;
            } else if (i < mid) {
                e = mid;
            } else {
                s = mid;
            }
        }

        return false;
    }
}
