package code.code100.question059;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/12
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int counter = 1;
        int i = 0, j = 0;
        int right = n - 1, down = n - 1, left = 0, up = 1;
        while (counter <= n * n) {
            while (j <= right) {
                ans[i][j] = counter;
                counter++;
                j++;
            }
            right--;
            j--;
            i++;
            while (i <= down) {
                ans[i][j] = counter;
                counter++;
                i++;
            }
            down--;
            i--;
            j--;
            while (j >= left) {
                ans[i][j] = counter;
                counter++;
                j--;
            }
            left++;
            j++;
            i--;
            while (i >= up) {
                ans[i][j] = counter;
                counter++;
                i--;
            }
            up++;
            i++;
            j++;
        }
        return ans;
    }
}
