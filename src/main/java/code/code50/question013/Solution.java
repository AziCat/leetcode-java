package code.code50.question013;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/12
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("MMCM".indexOf("M"));
        System.out.println("MMCM".substring(1));
    }

    /**
     * 方法二
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int temp = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                //最后一位直接做加法
                temp += map.get(s.charAt(i));
            } else {
                //如果当前字母值大于等于右边字母值则做加法，否则做减法
                temp = map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)) ? temp + map.get(s.charAt(i)) : temp - map.get(s.charAt(i));
            }
        }
        return temp;
    }

    /**
     * 方法一
     *
     * @param s
     * @return
     */
    public int romanToInt_(String s) {
        int temp = 0;
        int[] sign = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] reps = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < 13; i++) {
            while (s.startsWith(reps[i])) {
                s = s.substring(reps[i].length());
                temp += sign[i];
            }
        }
        return temp;
    }
}
