package code.code1300.question1269;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * <p>
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * <p>
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * <p>
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2021/5/17
 */
public class Solution {
    /**
     * dp[step][i] 表示 经过step次，停留在位置i的方案数
     * dp[step][i] = dp[step-1][i-1] + dp[step-1][i] + dp[step-1][i+1]
     * 每层结果只依赖上层的结果，所以可以压缩空间到一维
     *
     * @param steps
     * @param arrLen
     * @return
     */
    public int numWays(int steps, int arrLen) {
        if (arrLen > steps) {
            arrLen = steps;
        }
        int[] dp = new int[arrLen];
        dp[0] = 1;
        int[] pre = new int[2];
        for (int i = 1; i <= steps; i++) {
            pre[0] = dp[0];
            for (int j = 0; j < arrLen; j++) {
                pre[1] = pre[0];
                pre[0] = dp[j];
                if (j > 0) {
                    dp[j] = (dp[j] + pre[1]) % 1000000007;
                }
                if (j < arrLen - 1) {
                    dp[j] = (dp[j] + dp[j + 1]) % 1000000007;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String source = "您有由 ${display_created_by_role} zhu.jz.4@pg.com ";
        source = source.replaceAll(Pattern.quote("${display_created_by_role}"), "");
        System.out.println(source);

    }
}
