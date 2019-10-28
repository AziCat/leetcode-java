package code.code50.question036;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * <p>
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/25
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(0 + '1');
        System.out.println(0 + '2');
        System.out.println('1'+'2');
        char a = '4'+'5'-'1';
        System.out.println(a);
        System.out.println('1'<'9');
        System.out.println('a'<'9');
    }

    /**
     * 哈希表优化
     * <p>
     * 4 ms	43.1 MB
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        HashMap[] columnMap = new HashMap[9];
        HashMap[] rowMap = new HashMap[9];
        HashMap[] boardMap = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            columnMap[i] = new HashMap();
            rowMap[i] = new HashMap();
            boardMap[i] = new HashMap();
        }
        for (int i = 0; i < 9; i++) {
            Map subColumnMap = columnMap[i];
            for (int j = 0; j < 9; j++) {
                Map subRowMap = rowMap[j];
                int boardIndex = (i / 3) * 3 + j / 3;
                Map subBoardMap = boardMap[boardIndex];
                char item = board[i][j];
                if ('.' == item) {
                    continue;
                }
                if (subColumnMap.containsKey(item) || subRowMap.containsKey(item) || subBoardMap.containsKey(item)) {
                    return false;
                } else {
                    subColumnMap.put(item, i);
                    subRowMap.put(item, j);
                    subBoardMap.put(item, boardIndex);
                }
            }
        }
        return true;
    }

    /**
     * 使用哈希表
     * <p>
     * 64 ms	37.5 MB
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku_(char[][] board) {
        Map<Integer, Map<Character, Integer>> columnMap = new HashMap<>(9);
        Map<Integer, Map<Character, Integer>> rowMap = new HashMap<>(9);
        Map<String, Map<Character, String>> boardMap = new HashMap<>(9);
        for (int i = 0; i < 9; i++) {
            Map<Character, Integer> subColumnMap = columnMap.computeIfAbsent(i, k -> new HashMap<>());
            for (int j = 0; j < 9; j++) {
                Map<Character, Integer> subRowMap = rowMap.computeIfAbsent(j, k -> new HashMap<>(9));
                String boardIndex = "" + (i / 3 + 1) + (j / 3 + 1);
                Map<Character, String> subBoardMap = boardMap.computeIfAbsent(boardIndex, k -> new HashMap<>(9));
                char item = board[i][j];
                if ('.' == item) {
                    continue;
                }
                if (subColumnMap.containsKey(item) || subRowMap.containsKey(item) || subBoardMap.containsKey(item)) {
                    return false;
                } else {
                    subColumnMap.put(item, i);
                    subRowMap.put(item, j);
                    subBoardMap.put(item, boardIndex);
                }
            }
        }
        return true;
    }
}
