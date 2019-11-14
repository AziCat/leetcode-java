package code.code150.question120;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 动态规划，使用dp[]来存放当前层最小路径，自底向上
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
         if (triangle == null || triangle.size() == 0){
            return 0;
        }
        // 只需要记录每一层的最小值即可
        int[] dp = new int[triangle.size()+1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> curTr = triangle.get(i);
            for (int j = 0; j < curTr.size(); j++) {
                //这里的dp[j] 使用的时候默认是上一层的，赋值之后变成当前层
                dp[j] = Math.min(dp[j],dp[j+1]) + curTr.get(j);
            }
        }
        return dp[0];
    }

    /**
     * 使用动态规划，原地修改当前层数的最小路径和
     *
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> cur = triangle.get(i);
            min = Integer.MAX_VALUE;
            for (int j = 0; j < cur.size(); j++) {
                int distance;
                if (j == 0) {
                    distance = triangle.get(i - 1).get(0) + cur.get(0);
                } else if (j == cur.size() - 1) {
                    distance = triangle.get(i - 1).get(cur.size() - 2) + cur.get(cur.size() - 1);
                } else {
                    distance = cur.get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
                }
                min = Math.min(distance, min);
                cur.set(j, distance);
            }
        }
        return min;
    }
}

