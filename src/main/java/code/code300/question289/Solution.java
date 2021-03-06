package code.code300.question289;

/**
 * 根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/24
 */
public class Solution {

    /**
     * 状态转换
     * alive->dead  3
     * alive->alive 1
     * dead->dead   0
     * dead->alive  2
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        //设置中间状态
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int aliveCount = findAlive(i, j, board);
                if (board[i][j] == 1) {
                    if (aliveCount < 2 || aliveCount > 3) {
                        board[i][j] = 3;
                    }
                } else {
                    if (aliveCount == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        //重置
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] == 1 || board[i][j] == 2 ? 1 : 0;
            }
        }
    }

    private int findAlive(int i, int j, int[][] board) {
        int count = 0;
        if (i - 1 >= 0) {
            if (j - 1 >= 0 && board[i - 1][j - 1] % 2 == 1) {
                count++;
            }
            if (board[i - 1][j] % 2 == 1) {
                count++;
            }
            if (j + 1 < board[0].length && board[i - 1][j + 1] % 2 == 1) {
                count++;
            }
        }
        if (i + 1 < board.length) {
            if (j - 1 >= 0 && board[i + 1][j - 1] % 2 == 1) {
                count++;
            }
            if (board[i + 1][j] % 2 == 1) {
                count++;
            }
            if (j + 1 < board[0].length && board[i + 1][j + 1] % 2 == 1) {
                count++;
            }
        }
        if (j - 1 >= 0 && board[i][j - 1] % 2 == 1) {
            count++;
        }
        if (j + 1 < board[0].length && board[i][j + 1] % 2 == 1) {
            count++;
        }
        return count;
    }
}
