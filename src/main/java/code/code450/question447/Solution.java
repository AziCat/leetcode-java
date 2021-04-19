package code.code450.question447;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * <p>
 * 返回平面上所有回旋镖的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @version 1.0
 * @since 2021/4/19 16:33
 */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points.length < 3) {
            return 0;
        }
        //用hash表存放每个点到i点距离相同的点的数量，key为距离
        Map<Double,Integer>[] maps = new Map[points.length];
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new HashMap<>();
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double d = getDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
                Integer countI = maps[i].getOrDefault(d, 0);
                countI++;
                maps[i].put(d, countI);
                Integer countJ = maps[j].getOrDefault(d, 0);
                countJ++;
                maps[j].put(d, countJ);
            }
        }
        int ans = 0;
        for (Map<Double, Integer> map : maps) {
            for (Integer count : map.values()) {
                ans += count * (count - 1);
            }
        }
        return ans;
    }

    private double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
