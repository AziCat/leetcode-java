package code.code450.question417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * <p>
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * <p>
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/9/4
 */
public class Solution {
    private final List<List<Integer>> ans = new ArrayList<>();
    private int[][] matrix;

    /**
     * dfs
     *
     * @param matrix
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        this.matrix = matrix;
        if (matrix.length == 0) {
            return ans;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[][] visited = new int[rows][cols];
        //从太平洋开始逆流
        for (int col = 0; col < cols; col++) {
            //经过太平洋的标志为1
            dfs(0, col, visited, 1, 0);
        }
        for (int row = 0; row < rows; row++) {
            dfs(row, 0, visited, 1, 0);
        }
        //从大西洋开始逆流
        for (int col = 0; col < cols; col++) {
            dfs(rows - 1, col, visited, -1, 0);
        }
        for (int row = 0; row < rows; row++) {
            dfs(row, cols - 1, visited, -1, 0);
        }
        return ans;
    }

    private void dfs(int row, int col, int[][] visited, int flag, int high) {
        if (row >= 0 && row < visited.length && col >= 0 && col < visited[0].length && matrix[row][col] >= high) {
            if (visited[row][col] != flag) {
                if (visited[row][col] != 0) {
                    ans.add(Arrays.asList(row, col));
                }
                visited[row][col] = flag;
                //4个方向继续
                dfs(row + 1, col, visited, flag, matrix[row][col]);
                dfs(row - 1, col, visited, flag, matrix[row][col]);
                dfs(row, col + 1, visited, flag, matrix[row][col]);
                dfs(row, col - 1, visited, flag, matrix[row][col]);
            }
        }
    }
}
