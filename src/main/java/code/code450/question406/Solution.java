package code.code450.question406;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * <p>
 * 注意：
 * 总人数少于1100人。
 * <p>
 * 示例
 * <p>
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/8/25
 */
public class Solution {
    /**
     * [ 0, 1, 2, 3, 4, 5 ] [ 4, 4 ] 4
     * [ 0, 1, 2, 3, 5 ]    [ 5, 2 ] 2
     * [ 0, 1, 3, 5 ]       [ 5, 0 ] 0
     * [ 1, 3, 5 ]          [ 6, 1 ] 3
     * [ 1, 5 ]             [ 7, 1 ] 5
     * [ 1 ]                [ 7, 0 ] 1
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        //身高从矮到高，k从大到小
        List<Integer> positions = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < people.length; i++) {
            positions.add(i);
            queue.offer(people[i]);
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int position = positions.remove(p[1]);
            people[position] = p;
        }
        return people;
    }
}
