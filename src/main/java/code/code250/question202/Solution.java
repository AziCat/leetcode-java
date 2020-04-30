package code.code250.question202;

import java.util.HashSet;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例: 
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 1*1 + 9*9 = 82
 * 8*8 + 2*2 = 68
 * 6*6 + 8*8 = 100
 * 1*1 + 0*0 + 0*0 = 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/31
 */
public class Solution {
    /**
     * 双指针思路
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int fast = n, slow = n;
        do {
            fast = help(fast);
            fast = help(fast);
            slow = help(slow);
        } while (fast != slow);
        return fast == 1;
    }

    private int help(int num) {
        int sum = 0;
        while (0 != num) {
            int temp = num % 10;
            sum = sum + temp * temp;
            num /= 10;
        }
        return sum;
    }

    private final HashSet<Integer> cache = new HashSet<>();

    /**
     * 递归&哈希表
     *
     * @param n
     * @return
     */
    public boolean isHappy_(int n) {
        cache.add(n);
        int sum = 0;
        while (0 != n) {
            int temp = n % 10;
            sum = sum + temp * temp;
            n /= 10;
        }
        return 1 == sum || !cache.contains(sum) && isHappy_(sum);
    }

}
