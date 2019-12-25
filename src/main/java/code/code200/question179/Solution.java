package code.code200.question179;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/25
 */
public class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            char[] c1 = o1.toCharArray();
            char[] c2 = o2.toCharArray();
            int max = o1.length() + o2.length();
            for (int i = 0; i < max; i++) {
                char s1 = i < c1.length ? c1[i] : c2[i - c1.length];
                char s2 = i < c2.length ? c2[i] : c1[i - c2.length];
                if (s1 > s2) {
                    return -1;
                } else if (s1 < s2) {
                    return 1;
                }
            }
            return 0;
        });
        for (int num : nums) {
            queue.add(String.valueOf(num));
        }
        StringBuilder sb = new StringBuilder();
        if (queue.peek().equals("0")) {
            return "0";
        }
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
