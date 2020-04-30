package code.code400.question352;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的区间列表。
 * <p>
 * 例如，假设数据流中的整数为 1，3，7，2，6，…，每次的总结为：
 * <p>
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 *  
 * <p>
 * 进阶：
 * 如果有很多合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/4/10
 */
public class SummaryRanges {
    private final List<int[]> list;

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges() {
        this.list = new ArrayList<>();
    }

    public void addNum(int val) {
        if (list.isEmpty()) {
            addNum(val, 0);
        } else {
            //判断val是否在某区间内
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int[] area = list.get(i);
                if (val >= area[0] && val <= area[1]) {
                    //val在某区间内，直接退出
                    return;
                } else if (val < area[0]) {
                    //添加到当前区间前面
                    addNum(val, i);
                    return;
                }
            }
            //添加到最后
            addNum(val, size);
        }
    }

    private void addNum(int val, int index) {
        //检查能否与前面的区间合并
        boolean left = index != 0 && list.get(index - 1)[1] + 1 == val;
        //检查能否与后面的区间合并
        boolean right = index < list.size() && list.get(index)[0] - 1 == val;
        if (left && right) {
            int[] pre = list.remove(index - 1);
            list.get(index - 1)[0] = pre[0];
        } else if (left) {
            list.get(index - 1)[1] = val;
        } else if (right) {
            list.get(index)[0] = val;
        } else {
            list.add(index, new int[]{val, val});
        }

    }

    public int[][] getIntervals() {
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
