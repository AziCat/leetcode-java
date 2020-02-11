package code.code250.question218;

import java.util.*;

/**
 * 每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，Hi 是其高度。可以保证 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX 和 Ri - Li > 0。您可以假设所有建筑物都是在绝对平坦且高度为 0 的表面上的完美矩形。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-skyline-problem
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/1/16
 */
public class Solution {
    class Line {
        boolean isLeft;
        int x;
        int h;

        public Line(boolean isLeft, int x, int h) {
            this.isLeft = isLeft;
            this.x = x;
            this.h = h;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        //线排序
        PriorityQueue<Line> lineQueue = new PriorityQueue<>((l1, l2) -> {
            if (l1.x == l2.x) {
                if (l1.isLeft == l2.isLeft) {
                    return l1.h - l2.h;
                } else {
                    return l1.isLeft ? 1 : -1;
                }
            }
            return l1.x - l2.x;
        });
        for (int[] building : buildings) {
            lineQueue.add(new Line(true, building[0], building[2]));
            lineQueue.add(new Line(false, building[1], building[2]));
        }
        //高度堆，高的排前低的排后
        PriorityQueue<Integer> heightHeap = new PriorityQueue<>((h1, h2) -> h2 - h1);
        heightHeap.add(0);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> prePoint = null;
        //上一个右边线转折点
        List<Integer> preRightPoint = null;
        while (!lineQueue.isEmpty()) {
            Line line = lineQueue.poll();
            if (line.isLeft) {
                //大于堆顶
                if (line.h > heightHeap.peek()) {
                    //判断加入关键点与上个关键点是否在一条垂直中线上
                    if (prePoint != null && prePoint.get(0) == line.x) {
                        ans.remove(ans.size() - 1);
                        if (preRightPoint == null || preRightPoint.get(1) != line.h || preRightPoint.get(0) != line.x) {
                            //不等于上个右边转折点
                            prePoint = Arrays.asList(line.x, line.h);
                            ans.add(prePoint);
                        }else {
                            prePoint = null;
                        }
                    } else {
                        prePoint = Arrays.asList(line.x, line.h);
                        ans.add(prePoint);
                    }
                }
                heightHeap.add(line.h);
            } else {
                //高度出堆
                heightHeap.remove(line.h);
                if (line.h > heightHeap.peek()) {
                    preRightPoint = Arrays.asList(line.x, line.h);
                    prePoint = Arrays.asList(line.x, heightHeap.peek());
                    ans.add(prePoint);
                }
            }
        }

        return ans;
    }
}
