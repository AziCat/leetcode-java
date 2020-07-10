package code.code400.question365;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * <p>
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * <p>
 * 你允许：
 * <p>
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 * <p>
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/water-and-jug-problem
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/7/2
 */
public class Solution {
    //bfs可以把stack换成queue
    private final Stack<int[]> stack = new Stack<>();
    //出现过的组合
    private final Set<String> visited = new HashSet<>();

    /**
     * DFS
     * 每步操作可以具体分为以下几种
     * 把x装满
     * 把y装满
     * 把x倒空
     * 把y倒空
     * x向y倒水，直到x倒空或者y装满
     * y向x倒水，直到y倒空或者x装满
     * <p>
     * 进行操作后，判断结果是否已出现过，是则跳过，否则加入下层查找
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        int[] seed = new int[2];

        stack.push(seed);

        visited.add("0,0");
        while (!stack.empty()) {
            int[] tempWater = stack.pop();
            // 把x装满
            int sum = handleWater(x, tempWater[1]);
            if (sum == z) {
                return true;
            }
            // 把y装满
            sum = handleWater(tempWater[0], y);
            if (sum == z) {
                return true;
            }
            // 把x倒空
            sum = handleWater(0, tempWater[1]);
            if (sum == z) {
                return true;
            }
            // 把y倒空
            sum = handleWater(tempWater[0], 0);
            if (sum == z) {
                return true;
            }
            // x向y倒水，直到x倒空或者y装满
            sum = tempWater[0] < y - tempWater[1] ?
                    handleWater(0, tempWater[0] + tempWater[1]) :
                    handleWater(tempWater[0] + tempWater[1] - y, y);
            if (sum == z) {
                return true;
            }
            // y向x倒水，直到y倒空或者x装满
            sum = tempWater[1] < x - tempWater[0] ?
                    handleWater(tempWater[0] + tempWater[1], 0) :
                    handleWater(x, tempWater[0] + tempWater[1] - x);
            if (sum == z) {
                return true;
            }
        }
        return false;
    }

    private int handleWater(int x, int y) {
        int sum = x + y;
        String tempVisitedStr = x + "," + y;
        if (!visited.contains(tempVisitedStr)) {
            stack.push(new int[]{x, y});
            visited.add(tempVisitedStr);
        }
        return sum;
    }
}
