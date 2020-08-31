package code.code850.question841;

import java.util.List;

/**
 * @author yan
 * @version 1.0
 * @date 2020/8/31
 */
public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited = new int[rooms.size()];
        dfs(rooms, visited, 0);
        for (int i : visited) {
            if (i != 1) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int[] visited, int i) {
        if (visited[i] == 0) {
            visited[i] = 1;
            List<Integer> keys = rooms.get(i);
            for (Integer room : keys) {
                dfs(rooms, visited, room);
            }
        }
    }

}
