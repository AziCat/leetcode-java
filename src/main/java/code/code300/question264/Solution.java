package code.code300.question264;

/**
 * 编写一个程序，找出第 n 个丑数。
 * <p>
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/19
 */
public class Solution {
    /**
     * 使用3指针动态规划
     * 定义只存放丑数的数组dp，初始化是[1]，定义3个指针p2,p3,p5都指向dp第0个位置
     * <p>
     * <p>
     * dp[p2]*2 = 2
     * dp[p3]*3 = 3
     * dp[p5]*5 = 5
     * 最小值为2，则p2右移且把2放到dp数组中，此时dp数组为[1,2]，循环上述操作
     * p2=1,p3=0,p5=0
     * <p>
     * <p>
     * dp[p2]*2 = 4
     * dp[p3]*3 = 3
     * dp[p5]*5 = 5
     * 最小值为3，则p3右移且把3放到dp数组中，此时dp数组为[1,2,3]，循环上述操作
     * p2=1,p3=1,p5=0
     * <p>
     * <p>
     * dp[p2]*2 = 4
     * dp[p3]*3 = 6
     * dp[p5]*5 = 5
     * 最小值为4，则p2右移且把3放到dp数组中，此时dp数组为[1,2,3,4]，循环上述操作
     * p2=2,p3=1,p5=0
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        int dp2 = 2, dp3 = 3, dp5 = 5;
        int counter = 1;
        while (counter != n) {
            int min = Math.min(dp2, Math.min(dp3, dp5));
            dp[counter] = min;
            counter++;
            if (dp2 == min) {
                p2++;
                dp2 = 2 * dp[p2];
            }
            if (dp3 == min) {
                p3++;
                dp3 = 3 * dp[p3];
            }
            if (dp5 == min) {
                p5++;
                dp5 = 5 * dp[p5];
            }
        }
        return dp[n - 1];
    }
}
