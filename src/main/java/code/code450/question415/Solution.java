package code.code450.question415;

/**
 * @author yan
 * @version 1.0
 * @date 2020/9/3
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        char[] c1 = num1.toCharArray(), c2 = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (carry != 0 || i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += (c1[i--] - '0');
            }
            if (j >= 0) {
                carry += (c2[j--] - '0');
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}
