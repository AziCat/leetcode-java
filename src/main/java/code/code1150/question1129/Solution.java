package code.code1150.question1129;

import java.util.HashSet;
import java.util.Set;

/**
 * 在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。
 * <p>
 * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。
 * <p>
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * 输出：[0,1,-1]
 * 示例 2：
 * <p>
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * 输出：[0,1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shortest-path-with-alternating-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2023/2/2
 */
public class Solution {
    /**
     * 1 <= n <= 100
     * red_edges.length <= 400
     * blue_edges.length <= 400
     * red_edges[i].length == blue_edges[i].length == 2
     * 0 <= red_edges[i][j], blue_edges[i][j] < n
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/shortest-path-with-alternating-colors
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param redEdges
     * @param blueEdges
     * @return
     */
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ansRed = new int[n];
        int[] ansBlue = new int[n];
        int[] ans = new int[n];

        //每个点被哪些点指向
        Set<Integer> redFrom[] = new Set[n];
        Set<Integer> blueFrom[] = new Set[n];

        for (int[] redEdge : redEdges) {
            if (null == redFrom[redEdge[1]]) {
                redFrom[redEdge[1]] = new HashSet<>();
            }
            redFrom[redEdge[1]].add(redEdge[0]);
        }

        for (int[] blueEdge : blueEdges) {
            if (null == blueFrom[blueEdge[1]]) {
                blueFrom[blueEdge[1]] = new HashSet<>();
            }
            blueFrom[blueEdge[1]].add(blueEdge[0]);
        }
        for (int i = 1; i < n; i++) {
            bfs(i, redFrom[i], blueFrom[i], ansRed, ansBlue);
        }

        return ans;
    }

    private void bfs(int desPoint, Set<Integer> redPoints, Set<Integer> bluePoints, int[] ansRed, int[] ansBlue) {
        //红线
        if (null == redPoints) {
            ansRed[desPoint] = -1;
        } else {
            int red = Integer.MAX_VALUE;
            for (Integer redPoint : redPoints) {
                if (ansRed[redPoint] == 0) {
                    bfs(redPoint, redPoints, bluePoints, ansRed, ansBlue);
                } else {
                    red = Math.min(red, ansRed[redPoint]);
                }
            }
            ansRed[desPoint] = red;
        }

        //蓝线
        if (null == bluePoints) {
            ansBlue[desPoint] = -1;
        } else {
            int blue = Integer.MAX_VALUE;
            for (Integer bluePoint : bluePoints) {
                if (ansBlue[bluePoint] == 0) {
                    bfs(bluePoint, redPoints, bluePoints, ansRed, ansBlue);
                } else {
                    blue = Math.min(blue, ansBlue[bluePoint]);
                }
            }
            ansBlue[desPoint] = blue;
        }
    }


}
