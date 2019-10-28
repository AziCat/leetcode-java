package code.code50.question043;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/30
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] ansArr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int multiply = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
                int index = i + j + 1;
                int sum = multiply + ansArr[index];
                ansArr[index - 1] = sum / 10 + ansArr[index - 1];
                ansArr[index] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ansArr.length; i++) {
            if (i == 0 && ansArr[0] == 0) {
                continue;
            }
            sb.append(ansArr[i]);
        }
        return sb.toString();
    }
}
