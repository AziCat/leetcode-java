package code.code950.question909;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * 909. 蛇梯棋
 *
 * @author yjh
 * @since 2021/6/30
 */
public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        //将棋盘一维化
        int[] dp = new int[n * n + 1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int position = (n - 1 - i) % 2 == 0 ? (n - 1 - i) * n + j + 1 : (n - i) * n - j;
                dp[position] = board[i][j];
            }
        }
        boolean[] visited = new boolean[dp.length];
        visited[1] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1);
        //广搜
        return bfs(dp, queue, visited);
    }

    private int bfs(int[] dp, LinkedList<Integer> queue, boolean[] visited) {
        int step = 1;
        int size = queue.size();
        while (!queue.isEmpty()) {
            size--;
            int position = queue.poll();
            for (int i = position + 1; i < dp.length && i <= position + 6; i++) {
                int nextPosition = dp[i] != -1 ? dp[i] : i;
                if (nextPosition == dp.length - 1) {
                    return step;
                }
                if (!visited[nextPosition]) {
                    visited[nextPosition] = true;
                    queue.offer(nextPosition);
                }

            }
            if (size == 0) {
                size = queue.size();
                step++;
            }
        }
        return -1;
    }

}
