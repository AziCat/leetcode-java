package code.code600.question575;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: candies = [1,1,2,2,3,3]
 * 输出: 3
 * 解析: 一共有三种种类的糖果，每一种都有两个。
 * 最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distribute-candies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2021/11/1
 */
public class Solution {
    /**
     * 因为要平均分，所以妹妹最大的糖果种类为len/2，最小为1
     * 当遇到一个新种类的糖果，直接先给妹妹，如果妹妹持有的糖果种类超过len/2，直接返回len/2
     *
     * @param candyType
     * @return
     */
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i : candyType) {
            if (!set.contains(i)) {
                set.add(i);
                ans++;
                if (ans == candyType.length / 2) {
                    return ans;
                }

            }
        }
        return ans;
    }
    public void test(int count){
        if (++count < 10) {
            System.out.println(count);
            test(count);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.test(0);
    }
}
