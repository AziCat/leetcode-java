package code.code50.question012;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * IV            4
 * V             5
 * IX            9
 * X             10
 * XL            40
 * L             50
 * XC            90
 * C             100
 * CD            400
 * D             500
 * CM            900
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/12
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(2991 / 1000);
        System.out.println(2991 % 1000);
    }

    /**
     * 下面写法的优化
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] sign = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] reps = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < 13; i++) {
            while (num >= sign[i]) {
                sb.append(reps[i]);
                num -= sign[i];
            }
        }
        return sb.toString();
    }

    /**
     * 穷举法。。。
     *
     * @param num
     * @return
     */
    public String intToRoman_(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 1000) {
            for (int i = 0; i < num / 1000; i++) {
                sb.append("M");
            }
            num %= 1000;
        }
        if (num >= 900) {
            for (int i = 0; i < num / 900; i++) {
                sb.append("CM");
            }
            num %= 900;
        }
        if (num >= 500) {
            for (int i = 0; i < num / 500; i++) {
                sb.append("D");
            }
            num %= 500;
        }
        if (num >= 400) {
            for (int i = 0; i < num / 400; i++) {
                sb.append("CD");
            }
            num %= 400;
        }
        if (num >= 100) {
            for (int i = 0; i < num / 100; i++) {
                sb.append("C");
            }
            num %= 100;
        }
        if (num >= 90) {
            for (int i = 0; i < num / 90; i++) {
                sb.append("XC");
            }
            num %= 90;
        }
        if (num >= 50) {
            for (int i = 0; i < num / 50; i++) {
                sb.append("L");
            }
            num %= 50;
        }
        if (num >= 40) {
            for (int i = 0; i < num / 40; i++) {
                sb.append("XL");
            }
            num %= 40;
        }
        if (num >= 10) {
            for (int i = 0; i < num / 10; i++) {
                sb.append("X");
            }
            num %= 10;
        }
        if (num >= 9) {
            for (int i = 0; i < num / 9; i++) {
                sb.append("IX");
            }
            num %= 9;
        }
        if (num >= 5) {
            for (int i = 0; i < num / 5; i++) {
                sb.append("V");
            }
            num %= 5;
        }
        if (num >= 4) {
            for (int i = 0; i < num / 4; i++) {
                sb.append("IV");
            }
            num %= 4;
        }
        if (num >= 1) {
            for (int i = 0; i < num; i++) {
                sb.append("I");
            }
        }
        return sb.toString();
    }
}
