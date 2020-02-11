package code.code250.question214;

/**
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 * <p>
 * 输入: "abcd"
 * 输出: "dcbabcd"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/1/13
 */
public class Solution {
    public String shortestPalindrome_(String s) {
        int end = s.length() - 1;
        int cur = end;
        while (cur >= 0) {
            for (int i = 0; i <= end; i++) {
                if (s.charAt(i) != s.charAt(cur)) {
                    end--;
                    cur = end;
                    break;
                } else {
                    cur--;
                }
            }
        }
        StringBuilder sb = new StringBuilder(s.substring(end + 1, s.length())).reverse();
        return sb.append(s).toString();
    }

    public String shortestPalindrome(String s) {

        int n = s.length();
        int i = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)){
                i++;
            }
        }
        //最长回文串肯定在0~i的范围中，最好情况是i==n
        if (i == n) {
            return s;
        }
        String remain_rev = new StringBuilder(s.substring(i, n)).reverse().toString();
        //在0~i中继续递归，头部加上已反转的尾部分
        return remain_rev + shortestPalindrome(s.substring(0, i)) + s.substring(i);
    }
}
