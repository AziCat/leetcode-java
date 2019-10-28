package code.code100.question084;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/23
 */
public class Solution {
    /**
     * 分治
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        return findArea(heights, 0, heights.length - 1);
    }

    private int findArea(int[] heights, int l, int r) {
        if (r < l) {
            return 0;
        } else if (r == l) {
            return heights[l];
        }
        int minIndex = l;
        boolean sort = true;
        for (int i = l + 1; i <= r; i++) {
            if (heights[i - 1] > heights[i]) {
                sort = false;
            }
            if (heights[i] < heights[minIndex]) {
                minIndex = i;
            }
        }
        int max = heights[minIndex] * (r - l + 1);
        if (sort) {
            for (int i = l + 1; i <= r; i++) {
                max = Math.max(max, heights[i] * (r - i + 1));
            }
            return max;
        }
        return Math.max(max, Math.max(findArea(heights, l, minIndex - 1), findArea(heights, minIndex + 1, r)));
    }

    /**
     * 使用栈
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea__(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }
        return maxArea;
    }
}
