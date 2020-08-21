package code.code550.question529;

import java.util.ArrayList;
import java.util.List;

/**
 * 让我们一起来玩扫雷游戏！
 * <p>
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 * <p>
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * <p>
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minesweeper
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/8/20
 */
public class Solution {
    private char[][] board;

    public char[][] updateBoard(char[][] board, int[] click) {
        this.board = board;
        click(click[0], click[1]);
        return board;
    }

    private void click(int row, int col) {
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        }
        if (board[row][col] == 'E') {
            List<int[]> clickList = new ArrayList<>();
            char count = '0';
            for (int r = row - 1; r <= row + 1; r++) {
                for (int c = col - 1; c <= col + 1; c++) {
                    if (r >= board.length || r < 0 || c >= board[0].length || c < 0 || (r == row && c == col)) {
                        continue;
                    }
                    if (board[r][c] == 'M') {
                        count++;
                    } else if (board[r][c] == 'E') {
                        clickList.add(new int[]{r, c});
                    }
                }
            }
            if (count != '0') {
                board[row][col] = count;
            } else {
                board[row][col] = 'B';
                for (int[] click : clickList) {
                    click(click[0], click[1]);
                }
            }
        }
    }
}
