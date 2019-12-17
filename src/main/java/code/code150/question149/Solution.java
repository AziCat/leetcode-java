package code.code150.question149;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 * <p>
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/3
 */
public class Solution {
    private int ans = 0;

    public int maxPoints(int[][] points) {
        //当在一条直接上的点，满足方程y=ax+b，以a-b为key，点的索引位置为value存放在map中
        Map<String, HashSet<Integer>> map = new HashMap<>();

        int len = points.length;
        if (len < 3) {
            return len;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
                String key;
                //特殊情况x=k或者y=k
                if (x1 == x2) {
                    key = "y-" + x1;
                } else if (y1 == y2) {
                    key = "x-" + y1;
                } else {
                    float a = (y1 - y2) / (x1 - x2);
                    float b = y1 - a * x1;
                    key = a + "-" + b;
                }
                HashSet<Integer> pointSet = map.getOrDefault(key, new HashSet<>());
                if (!pointSet.contains(i)) {
                    pointSet.add(i);
                }
                if (!pointSet.contains(j)) {
                    pointSet.add(j);
                }
                ans = Math.max(ans, pointSet.size());
                map.put(key, pointSet);
            }
        }
        return ans;
    }
}
