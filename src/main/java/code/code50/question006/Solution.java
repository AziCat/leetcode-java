package code.code50.question006;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/11
 */
public class Solution {
    /**
     * 找规律，得出每一行两个字母下标间的规律
     * 解题思路类似于https://leetcode-cn.com/problems/zigzag-conversion/solution/6-z-zi-xing-bian-huan-c-c-by-bian-bian-xiong/
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int maxSkip = 2 * numRows - 2;
        for (int i = 1; i <= numRows; i++) {
            //得出当前行跳跃数
            int skip;
            if (i == numRows) {
                skip = 2 * numRows - 2;
            } else {
                skip = 2 * numRows - 2 * i;
            }
            int start = i - 1;
            int temp = skip;
            while (start < s.length()) {
                sb.append(s.charAt(start));
                start = start + temp;
                temp = maxSkip - temp == 0 ? maxSkip : maxSkip - temp;
            }
        }
        return sb.toString();
    }

    /**
     * 官方一解，居然还能这么解绝了
     * @param s
     * @param numRows
     * @return
     */
    public String convert_(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }
}
