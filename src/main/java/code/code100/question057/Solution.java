package code.code100.question057;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 链接：https://leetcode-cn.com/problems/insert-interval
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/11
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ansList = new ArrayList<>();
        if (intervals.length == 0) {
            ansList.add(newInterval);
        }
        boolean isAppend = false;
        //ansList.add(intervals[0]);
        for (int i = 0; i < intervals.length; i++) {
            int[] last, compare;
            if (isAppend) {
                last = ansList.remove(ansList.size() - 1);
                compare = intervals[i];
            } else {
                last = intervals[i];
                compare = newInterval;
            }
            if (compare[0] > last[1]) {
                ansList.add(last);
                if (isAppend || i == intervals.length - 1) {
                    ansList.add(compare);
                }
            } else {
                if (compare[0] <= last[0]) {
                    if (compare[1] < last[0]) {
                        ansList.add(compare);
                    }else {
                        last[0] = compare[0];
                    }
                }
                if (compare[1] >= last[1]) {
                    last[1] = compare[1];
                }
                isAppend = true;
                ansList.add(last);
            }
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
