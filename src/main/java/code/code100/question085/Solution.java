package code.code100.question085;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/23
 */
public class Solution {
    /**
     * 以每一行为底，求最大矩阵面积
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] temp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    temp[i][j] = Character.getNumericValue(matrix[i][j]);
                } else {
                    if (matrix[i][j] != '0') {
                        temp[i][j] = temp[i - 1][j] + Character.getNumericValue(matrix[i][j]);
                    }
                }
            }

        }
        int maxArea = 0;
        for (int[] nums : temp) {
            maxArea = Math.max(maxArea, largestRectangleArea(nums));
        }
        return maxArea;
    }

    /**
     * question84的解
     *
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
}
