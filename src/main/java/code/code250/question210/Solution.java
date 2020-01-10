package code.code250.question210;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * <p>
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 * <p>
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/1/8
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        LinkedList<int[]> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[1]] += 1;
            queue.add(prerequisite);
        }
        //入度为0的出队列，入排重set，指向的课程入度-1
        int counter = numCourses;
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        while (!queue.isEmpty() && counter > 0) {
            int[] prerequisite = queue.pop();
            if (inDegree[prerequisite[0]] == 0) {
                set.add(prerequisite[0]);
                inDegree[prerequisite[1]] -= 1;
                counter = queue.size();
                if (counter == 0) {
                    set.add(prerequisite[1]);
                }
            } else {
                queue.add(prerequisite);
                counter--;
            }
        }
        if (!queue.isEmpty()) {
            return new int[]{};
        } else {
            if (set.size() != numCourses) {
                for (int i = 0; i < numCourses; i++) {
                    set.add(i);
                }
            }
            int[] ans = new int[numCourses];
            int index = numCourses - 1;
            for (Integer aSet : set) {
                ans[index] = aSet;
                index--;
            }
            return ans;
        }
    }
}
