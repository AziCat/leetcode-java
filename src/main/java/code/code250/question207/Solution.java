package code.code250.question207;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/1/6
 */
public class Solution {
    /**
     * 拓扑排序
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] require = new int[numCourses];
        LinkedList<int[]> queue = new LinkedList<>();
        //统计每节课被指向的次数，并添加到队列中
        for (int[] prerequisite : prerequisites) {
            queue.add(prerequisite);
            require[prerequisite[1]] += 1;
        }
        int counter = numCourses;
        //遍历
        while (!queue.isEmpty() && counter > 0) {
            int[] prerequisite = queue.pop();
            if (require[prerequisite[0]] == 0) {
                //没有被指向
                require[prerequisite[1]] -= 1;
                counter = queue.size();
            } else {
                queue.addLast(prerequisite);
                counter--;
            }
        }
        return queue.isEmpty();
    }
}
