package code.code400.question384;

import java.util.Random;

/**
 * 打乱一个没有重复元素的数组。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 * <p>
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 * <p>
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/7/15
 */
public class Solution {
    private final int[] source;
    private final int[] shuffle;
    private final Random random;

    public Solution(int[] nums) {
        this.source = nums;
        this.shuffle = new int[nums.length];
        System.arraycopy(source, 0, shuffle, 0, source.length);
        this.random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return source;
    }

    /**
     * 洗牌算法
     * 第i个位置的牌，从i~n的位置中选择
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < source.length; i++) {
            int r = random.nextInt(source.length - i) + i;
            swap(shuffle, i, r);
        }
        return shuffle;
    }

    private void swap(int[] temp, int i, int r) {
        int val = temp[i];
        temp[i] = temp[r];
        temp[r] = val;
    }


}
