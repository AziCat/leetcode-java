package code.code100.question056;

import java.util.*;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/11
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return intervals;
        }
        int mergeCount = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][1] >= intervals[j][0] && intervals[i][0] <= intervals[j][1]) {
                    if (intervals[i][1] > intervals[j][1]) {
                        intervals[j][1] = intervals[i][1];
                    }
                    if (intervals[i][0] < intervals[j][0]) {
                        intervals[j][0] = intervals[i][0];
                    }
                    intervals[i] = null;
                    mergeCount++;
                    break;
                }
            }
        }
        int[][] result = new int[intervals.length - mergeCount][];
        for (int i = 0, j = 0; j < intervals.length; j++) {
            if (intervals[j] != null) {
                result[i++] = intervals[j];
            }
        }
        return result;
    }

    public int[][] merge1(int[][] intervals) {
        LinkedList<int[]> ansList = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int[] interval : intervals) {
            if (ansList.isEmpty()) {
                ansList.push(new int[]{interval[0], interval[1]});
                continue;
            }
            int[] head = ansList.peek();
            if (interval[0] > head[1]) {
                ansList.push(new int[]{interval[0], interval[1]});
            } else {
                if (interval[1] > head[1]) {
                    head[1] = interval[1];
                }
            }
        }
        int[][] ans = new int[ansList.size()][2];
        int i = 0;
        while (!ansList.isEmpty()) {
            ans[i] = ansList.pop();
            i++;
        }
        return ans;
    }
}
