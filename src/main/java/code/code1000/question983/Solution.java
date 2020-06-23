package code.code1000.question983;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * <p>
 * 火车票有三种不同的销售方式：
 * <p>
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * <p>
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/5/6
 */
public class Solution {
    /**
     * 动态规划
     *
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        //dp[i]表示完成day[i-1]旅行需要的最低花费
        int[] dp = new int[days.length + 1];
        //三个票价的有效位置
        int p1 = 0, p2 = 0, p3 = 0;
        for (int i = 1; i <= days.length; i++) {
            //单天费用
            int m1 = dp[p1] + costs[0];
            p1++;
            //7天费用
            while (days[i - 1] - days[p2] >= 7) {
                p2++;
            }
            int m2 = dp[p2] + costs[1];
            //30天费用
            while (days[i - 1] - days[p3] >= 30) {
                p3++;
            }
            int m3 = dp[p3] + costs[2];
            dp[i] = Math.min(m1, Math.min(m2, m3));
        }
        return dp[days.length];
    }
}
