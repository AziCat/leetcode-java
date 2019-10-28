package code.code50.question038;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 1
 * 1->1个1->11
 * 11->2个1->21
 * 21->1个2，1个1->1211
 * 1211->1个1，1个2，2个1->111221
 * 链接：https://leetcode-cn.com/problems/count-and-say
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/27
 */
public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String previous = countAndSay(n - 1);
            return readStr(previous);
        }
    }

    private String readStr(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        if (chars.length == 1) {
            sb.append(count).append(str);
        } else {
            int j = 1;
            for (int i = 0; i < chars.length && j < chars.length; ) {
                char head = chars[i];
                char next = chars[j];
                if (head == next) {
                    count++;
                    j++;
                } else {
                    i = j;
                }
                if (i == j || j == chars.length) {
                    sb.append(count).append(head);
                    count = 1;
                    j++;
                    if (j == chars.length) {
                        sb.append(count).append(chars[j - 1]);
                    }
                }

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.readStr("11"));
    }
}
