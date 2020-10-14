package code.code450.question435;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 * 注意:
 * <p>
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * <p>
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/10/13
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int ans=0;
        //起点升序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length-1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                //区间重合时，终点以最小的区间合并
                intervals[i + 1][1] = Math.min(intervals[i][1], intervals[i + 1][1]);
                ans++;
            }
        }
        return ans;
    }
    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int ans=0;
        //起点升序，终点降序
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        for (int[] interval : intervals) {
            queue.offer(interval);
        }
        int[] pre = queue.poll();
        while (!queue.isEmpty()) {
            int[] cur = queue.peek();
            //比较前区间与当前区间
            if (cur[0] < pre[1]) {
                //区间重合
                if (cur[1] > pre[1]) {
                    //移除当前区间
                    queue.poll();
                    ans++;
                }else {
                    //移除前区间
                    pre = queue.poll();
                    ans++;
                }
            }else {
                //不重合
                pre = queue.poll();
            }
        }
        return ans;
    }
}
