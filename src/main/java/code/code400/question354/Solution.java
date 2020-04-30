package code.code400.question354;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 说明:
 * 不允许旋转信封。
 * <p>
 * 示例:
 * <p>
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/4/13
 */
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length <= 0) return 0;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int i = 0; i < envelopes.length; i++) {
            if (len == 0) {
                dp[len] = envelopes[i][1];
                len++;
                continue;
            }
            int start = 0;
            int end = len - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (dp[mid] == envelopes[i][1]) {
                    start = mid;
                    break;
                } else if (dp[mid] > envelopes[i][1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (start == len) {
                len++;
            }
            dp[start] = envelopes[i][1];
        }
        return len;
    }

    public int maxEnvelopes_(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        int ans = 1;
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1 == o2) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = dp.length - 2; i >= 0; i--) {
            int max = dp[i];
            for (int j = i + 1; j < dp.length; j++) {
                if (envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1]) {
                    max = Math.max(max, dp[i] + dp[j]);
                }
            }
            dp[i] = max;
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
