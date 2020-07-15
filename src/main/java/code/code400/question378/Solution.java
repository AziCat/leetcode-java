package code.code400.question378;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * 返回 13。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/7/10
 */
public class Solution {
    static class Node {
        int[] nums;
        int cur = 0;

        public Node(int[] nums) {
            this.nums = nums;
        }
    }

    /**
     * 优先队列
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Node> queue = new PriorityQueue<>(n, Comparator.comparingInt(o -> o.nums[o.cur]));
        for (int[] ints : matrix) {
            queue.offer(new Node(ints));
        }
        while (k > 1) {
            Node node = queue.poll();
            node.cur++;
            if (node.cur < node.nums.length) {
                queue.offer(node);
            }
            k--;
        }
        return queue.peek().nums[queue.peek().cur];
    }

    /**
     * 二分法
     * 左上角的值不大于右下角的值
     * 假设一个中值，计算小于等于中值的个数
     * 如果个数大于k，说明中值偏大
     * 如果个数小于k，说明中值偏小
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(mid, matrix, n, k)) {
                //中值偏大
                right = mid;
            } else {
                //中值偏小
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 检查小于等于中值的个数是否大于k
     *
     * @param mid
     * @param matrix
     * @param n
     * @param k
     * @return
     */
    private boolean check(int mid, int[][] matrix, int n, int k) {
        int i = n - 1, j = 0, num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > mid) {
                i--;
            } else {
                num += i + 1;
                j++;
            }
        }
        return num >= k;
    }
}
