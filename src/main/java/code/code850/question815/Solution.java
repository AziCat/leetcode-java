package code.code850.question815;

import java.util.*;

/**
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * <p>
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * <p>
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bus-routes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2021/6/28
 */
public class Solution {
    //车站-有哪些路线经过
    private final Map<Integer, Set<Integer>> sourceRoutesMap = new HashMap<>();
    //路线-与哪些路线相交
    private final Map<Integer, Set<Integer>> routeCrossMap = new HashMap<>();

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        for (int r = 0; r < routes.length; r++) {
            //r为当前路线
            for (int s = 0; s < routes[r].length; s++) {
                //当前车站有哪些路线经过
                Set<Integer> routeSet = sourceRoutesMap.getOrDefault(routes[r][s], new HashSet<>());
                for (Integer route : routeSet) {
                    //路线相交
                    Set<Integer> crossRouteSet = routeCrossMap.getOrDefault(route, new HashSet<>());
                    crossRouteSet.add(r);
                    routeCrossMap.put(route, crossRouteSet);
                    //路线相交
                    crossRouteSet = routeCrossMap.getOrDefault(r, new HashSet<>());
                    crossRouteSet.add(route);
                    routeCrossMap.put(r, crossRouteSet);
                }
                //添加当前路线
                routeSet.add(r);
                sourceRoutesMap.put(routes[r][s], routeSet);
            }
        }
        //已访问的路线
        Set<Integer> visited = new HashSet<>();
        //使用队列进行bfs
        LinkedList<Integer> queue = new LinkedList<>();

        int ans = 1;
        //目标有哪些路线经过
        Set<Integer> targetRouteSet = sourceRoutesMap.get(target);
        if (null == targetRouteSet || targetRouteSet.isEmpty()) {
            return -1;
        }
        //source有哪些路线经过，入栈
        Set<Integer> routeSet = sourceRoutesMap.get(source);
        if (null != routeSet && !routeSet.isEmpty()) {
            for (Integer route : routeSet) {
                visited.add(route);
                queue.offer(route);
            }
        }
        return bfs(queue, ans, visited, targetRouteSet);
    }

    private int bfs(LinkedList<Integer> queue, int ans, Set<Integer> visited, Set<Integer> targetRouteSet) {
        LinkedList<Integer> nextQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            int currentRoute = queue.poll();
            if (targetRouteSet.contains(currentRoute)) {
                return ans;
            }
            Set<Integer> nextRouteSet = routeCrossMap.getOrDefault(currentRoute, new HashSet<>());
            for (Integer nextRoute : nextRouteSet) {
                if (!visited.contains(nextRoute)) {
                    visited.add(nextRoute);
                    nextQueue.offer(nextRoute);
                }
            }
        }
        return nextQueue.isEmpty() ? -1 : bfs(nextQueue, ans + 1, visited, targetRouteSet);
    }
}
