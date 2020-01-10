package code.code250.question212;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/1/9
 */
public class Solution {
    private List<String> ans = new ArrayList<>();
    private char[][] board;
    private boolean flag = false;

    /**
     * 递归回溯
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        for (String word : words) {
            flag = false;
            //寻找起点
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        //选择
                        choose(word, 0, i, j);
                        //退回
                        board[i][j] = word.charAt(0);
                        if (flag) {
                            //已添加当前单词，跳出循环
                            break;
                        }
                    }
                }
                if (flag) {
                    //已添加当前单词，跳出循环
                    break;
                }
            }
        }
        return ans;
    }

    private void choose(String word, int index, int row, int col) {
        //已选择的路径标记为'.'
        board[row][col] = '.';
        if (index == word.length() - 1) {
            flag = true;
            ans.add(word);
        } else {
            backtrack(word, index + 1, row, col);
        }
    }

    private void backtrack(String word, int index, int row, int col) {
        char c = word.charAt(index);
        //上
        if (!flag && row != 0 && board[row - 1][col] == c) {
            //选择
            choose(word, index, row - 1, col);
            //退回
            board[row - 1][col] = c;
        }
        //下
        if (!flag && row != board.length - 1 && board[row + 1][col] == c) {
            //选择
            choose(word, index, row + 1, col);
            //退回
            board[row + 1][col] = c;
        }
        //左
        if (!flag && col != 0 && board[row][col - 1] == c) {
            //选择
            choose(word, index, row, col - 1);
            //退回
            board[row][col - 1] = c;
        }
        //右
        if (!flag && col != board[0].length - 1 && board[row][col + 1] == c) {
            //选择
            choose(word, index, row, col + 1);
            //退回
            board[row][col + 1] = c;
        }
    }
}
