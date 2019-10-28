package code.code100.question051;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * 链接：https://leetcode-cn.com/problems/n-queens
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/10
 */
public class Solution {
    private char[][] checkerboard;
    private int[] rowBox;//记录横向已占用位置
    private int[] colBox;//记录竖向已占用位置
    private int[] xBox1;//记录正斜向已占用位置
    private int[] xBox2;//记录反斜向已占用位置
    private List<List<String>> ans = new ArrayList<>();

    /**
     * 使用回溯算法解n皇后
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        this.checkerboard = new char[n][n];
        this.rowBox = new int[n];
        this.colBox = new int[n];
        this.xBox1 = new int[2 * n - 1];
        this.xBox2 = new int[2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                checkerboard[i][j] = '.';
            }
        }
        backtrack(0);
        return ans;
    }

    private void backtrack(int row) {
        for (int j = 0; j < checkerboard.length; j++) {
            if (rowBox[row] == 0 && colBox[j] == 0 && xBox1[row + j] == 0 && xBox2[row - j - 1 + checkerboard.length] == 0) {
                putQueen(row, j);
                removeQueen(row, j);
            }
        }
    }

    private void removeQueen(int row, int col) {
        rowBox[row] = 0;
        colBox[col] = 0;
        xBox1[row + col] = 0;
        xBox2[row - col - 1 + checkerboard.length] = 0;
        checkerboard[row][col] = '.';
    }

    private void putQueen(int row, int col) {
        rowBox[row] = -1;
        colBox[col] = -1;
        xBox1[row + col] = -1;
        xBox2[row - col - 1 + checkerboard.length] = -1;
        checkerboard[row][col] = 'Q';
        if (row == checkerboard.length - 1) {
            List<String> list = new ArrayList<>();
            for (char[] strings : checkerboard) {
                list.add(new String(strings));
            }
            ans.add(list);
        } else {
            backtrack(row + 1);
        }
    }
}
