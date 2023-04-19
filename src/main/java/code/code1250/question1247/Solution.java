package code.code1250.question1247;

/**
 * @author yjh
 * @since 2023/2/25
 */
public class Solution {
    /**
     * 我们记s1[i] = x, s2[i] = y这种情况为xy，s1[i] = y, s2[i] = x这种情况为yx，分别统计两种情况的个数xy_c和yx_c：
     * <p>
     * xy内部两两配对，交换次数为xy_c / 2；xy_c是偶数刚好两两配对完，xy_c是奇数，就会剩下一个xy就需要yx也有一个富裕的和它配对；
     * yx内部两两配对，交换次数为yx_c / 2；yx_c是偶数刚好两两配对完，yx_c是奇数，就会剩下一个yx就需要xy也有一个富裕的和它配对；
     * 因此我们可以看到：
     * <p>
     * 如果xy是奇数对，那么yx也必须是奇数对，两个各剩一个再搭成一对，交换次数再加2；
     * 如果xy和yx都是偶数数对，刚好内部配对完；
     * 如果一个是奇数对一个是偶数对，那么肯定会剩一个没得配对，无法完成交换。即xy_c + yx_c是奇数的话，一定无法完成交换。
     * <p>
     *
     * @param s1
     * @param s2
     * @return
     */
    public int minimumSwap(String s1, String s2) {
        int xy = 0;
        int yx = 0;
        char c1;
        char c2;
        for (int i = 0; i < s1.length(); i++) {
            c1 = s1.charAt(i);
            c2 = s2.charAt(i);
            // 分别统计xy和yx的对数
            if (c1 == 'x' && c2 == 'y') {
                xy++;
            }
            if (c1 == 'y' && c2 == 'x') {
                yx++;
            }
        }
        // 两者对数和为奇数，肯定无法完成交换
        if ((xy + yx) % 2 == 1) {
            return -1;
        }
        // xy / 2 和 yx / 2 表示内部配对，每两个配成一对交换一次
        // 如果两个都是偶数对，xy % 2 + yx % 2 = 0 + 0 = 0
        // 如果两个都是奇数对，xy % 2 + yx % 2 = 1 + 1 = 2，刚好表示各剩一个需要交换两次
        return xy / 2 + yx / 2 + (xy % 2 + yx % 2);
    }
}
