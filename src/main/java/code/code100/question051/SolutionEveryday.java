package code.code100.question051;

import java.util.ArrayList;
import java.util.Arrays;
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
public class SolutionEveryday {
    private final List<List<String>> ans = new ArrayList<>();

    //记录四个方向是否已放置了皇后
    private int[] rowBox;
    private int[] colBox;
    private int[] xBox;
    private int[] yBox;

    //棋盘
    private char[][] chessBox;

    private int n;

    /**
     * 使用回溯算法解n皇后
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        this.rowBox = new int[n];
        this.colBox = new int[n];
        this.xBox = new int[2 * n - 1];
        this.yBox = new int[2 * n - 1];
        this.chessBox = new char[n][n];
        for (char[] box : chessBox) {
            Arrays.fill(box,'.');
        }
        this.n = n;

        putQueen(0);

        return ans;
    }

    private void putQueen(int row) {
        if (row >= n) {
            List<String> sub = new ArrayList<>();
            for (char[] box : chessBox) {
                sub.add(new String(box));
            }
            ans.add(sub);
            return;
        }
        for (int col = 0; col < n; col++) {
            //检查可以放置皇后
            if (rowBox[row] != 1 && colBox[col] != 1 && xBox[row + col] != 1 && yBox[n - 1 - row + col] != 1) {
                //放置皇后并标志位置占用
                chessBox[row][col] = 'Q';
                rowBox[row] = 1;
                colBox[col] = 1;
                xBox[row + col] = 1;
                yBox[n - 1 - row + col] = 1;

                //下一行放置皇后
                putQueen(row + 1);

                //移除皇后
                rowBox[row] = 0;
                colBox[col] = 0;
                xBox[row + col] = 0;
                yBox[n - 1 - row + col] = 0;
                chessBox[row][col] = '.';
            }
        }
    }


}
