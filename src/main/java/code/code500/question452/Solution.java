package code.code500.question452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 用最少数量的箭引爆气球
 * @author yjh
 * @since 2021/4/30
 */
public class Solution {
    /**
     * 贪心算法，每个气球最少会有一支箭穿过，以气球的右边界从小到大排序，箭按顺序从右边界射出
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        int ans = 1;
        //排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        //箭的位置
        int arrow = points[0][1];
        for (int i = 1; i < points.length; i++) {
            //后面的气球右边界肯定大于 arrow，如果左边界也大于arrow，说明当前arrow穿不过此气球
            if (points[i][0] > arrow) {
                arrow=points[i][1];
                ans++;
            }

        }
        return ans;
    }
}
